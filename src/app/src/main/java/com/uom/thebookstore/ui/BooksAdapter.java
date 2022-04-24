package com.uom.thebookstore.ui;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uom.thebookstore.objects.Book;

public class BooksAdapter extends BaseAdapter {

    private final Context mContext;
    private final Book[] books;

    public BooksAdapter(Context context, Book[] books) {
        this.mContext = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final Book book = books[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_book, null);
        }

    //    final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_book_name);
        final TextView priceTextView = (TextView)convertView.findViewById(R.id.textview_book_price);
      //  final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);


       // imageView.setImageResource(book.getImageResource());
        nameTextView.setText(book.getBookTitle());
        priceTextView.setText("$"+ book.getPrice());


        return convertView;
    }

}