package com.example.pocketlibrary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterActivity extends RecyclerView.Adapter<adapterActivity.BookViewHolder> {

 
    private ArrayList<infoRelatedBooks> infoRelatedBooksArrayList;
    private Context mcontext;

    public adapterActivity(ArrayList<infoRelatedBooks> infoRelatedBooksArrayList, Context mcontext) {
        this.infoRelatedBooksList = infoRelatedBooksArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

   
        infoRelatedBooks infoRelatedBooks = infoRelatedBooksArrayList.get(position);
        holder.nameTV.setText(infoRelatedBooks.getTitle());
        holder.publisherTV.setText(infoRelatedBooks.getPublisher());
        holder.pageCountTV.setText("No of Pages : " + infoRelatedBooks.getPageCount());
        holder.dateTV.setText(infoRelatedBooks.getPublishedDate());

        
        Picasso.get().load(infoRelatedBooks.getThumbnail()).into(holder.bookIV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent i = new Intent(mcontext, detailActivity.class);
                i.putExtra("title", infoRelatedBooks.getTitle());
                i.putExtra("subtitle", infoRelatedBooks.getSubtitle());
                i.putExtra("authors", infoRelatedBooks.getAuthors());
                i.putExtra("publisher", infoRelatedBooks.getPublisher());
                i.putExtra("publishedDate", infoRelatedBooks.getPublishedDate());
                i.putExtra("description", infoRelatedBooks.getDescription());
                i.putExtra("pageCount", infoRelatedBooks.getPageCount());
                i.putExtra("thumbnail", infoRelatedBooks.getThumbnail());
                i.putExtra("previewLink", infoRelatedBooks.getPreviewLink());
                i.putExtra("infoLink", infoRelatedBooks.getInfoLink());
                i.putExtra("buyLink",infoRelatedBooks.getBuyLink());

               
                mcontext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
       
        return infoRelatedBooksArrayList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
      
   
        TextView nameTV, publisherTV, pageCountTV, dateTV;
        ImageView bookIV;

        public BookViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.idTVBookTitle);
            publisherTV = itemView.findViewById(R.id.idTVpublisher);
            pageCountTV = itemView.findViewById(R.id.idTVPageCount);
            dateTV = itemView.findViewById(R.id.idTVDate);
            bookIV = itemView.findViewById(R.id.idIVbook);
        }
    }
}

