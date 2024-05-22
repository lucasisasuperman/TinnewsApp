package com.laioffer.tinnews.ui.save;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.tinnews.R;
import com.laioffer.tinnews.databinding.SavedNewsItemBinding;
import com.laioffer.tinnews.model.Article;

import java.util.ArrayList;
import java.util.List;

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder>{
    interface ItemCallback {
        void onOpenDetails(Article article);
        //open a new fragment for article details
        void onRemoveFavorite(Article article);
        //remove article in the saved database
    }

    private ItemCallback itemCallback;
    //use the itemCallback to inform the implementer the onRemoveFavourite event
    //when the favouriteIcon is clicked also inform the opening for the details event

    public void setItemCallback(ItemCallback itemCallback) { //实现这个接口需要外界传入

        this.itemCallback = itemCallback;
    }



    // 1. Supporting data: a list of articles
    // TODO
    private List<Article> articles = new ArrayList<>();

    public void setArticles(List<Article> newsList) {
        articles.clear();
        articles.addAll(newsList);
        notifyDataSetChanged();
        //everytime a new list set, let the adapter refresh and re-render the data
    }


    // 2. Adapter overrides:
    //the following three functions: only as many view holders as needed to display
    //the onscreen portion of the dynamic content are created
    // TODO
    @NonNull
    @Override
    public SavedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //generated item views
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_news_item, parent, false);
        return new SavedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedNewsViewHolder holder, int position) {
        //binding the data with a view
        Article article = articles.get(position);
        holder.authorTextView.setText(article.author);
        holder.descriptionTextView.setText(article.description);

        holder.favoriteIcon.setOnClickListener(v -> itemCallback.onRemoveFavorite(article));
        holder.itemView.setOnClickListener(v -> itemCallback.onOpenDetails(article));
        //notifies the outside callback listener that onOpenDetails is called
        //一旦点击这个事件发生发生了这两个行为，发生remove和open这两个事件
        //itemCallback

    }

    @Override
    public int getItemCount() {
        //providing the current data
        return articles.size();
        //this one is not 0
    }



    // 3. SavedNewsViewHolder:
    // TODO
    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder {
        //holding the view references

        TextView authorTextView;
        TextView descriptionTextView;
        ImageView favoriteIcon;

        public SavedNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            SavedNewsItemBinding binding = SavedNewsItemBinding.bind(itemView);
            authorTextView = binding.savedItemAuthorContent;
            descriptionTextView = binding.savedItemDescriptionContent;
            favoriteIcon = binding.savedItemFavoriteImageView;
        }
    }


}
