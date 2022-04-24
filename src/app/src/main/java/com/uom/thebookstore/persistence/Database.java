package com.uom.thebookstore.persistence;
import com.uom.thebookstore.objects.Book;
import java.util.ArrayList;

public class Database
{
    private ArrayList<ArrayList> list;

    public Database()
    {
        list = new ArrayList<ArrayList>();
        list.add(new ArrayList<Book>());
    }

    // Create a new Column
    public void addNewColumn()
    {
        ArrayList<Book> tempList = new ArrayList<Book>();
        list.add(tempList);
    }

    // Enter data into a column
    public void addData(int columnNum, Book iBook)
    {
        ArrayList<Book> tempList = list.get(columnNum);
        tempList.add(iBook);
    }


    // Delete data from the selected column
    public void deleteData(int columnNum, Book iBook)
    {
        ArrayList<Book> tempList = list.get(columnNum);
        int delIndex = -1;
        delIndex = tempList.indexOf(iBook);
        if (delIndex != -1)
        {
            tempList.remove(delIndex);
        }
    }

    public Book viewBook(int columnNum, int rowNum)
    {
        ArrayList<Book> tempList = list.get(columnNum);
        Book retBook = tempList.get(rowNum);

        return retBook;
    }

    // Print specific column
    public void printColumn(int columnNum)
    {
        ArrayList<Book> tempList = list.get(columnNum);

        for(int i = 0; i < tempList.size(); i++)
        {
            System.out.println(tempList.get(i).getBookTitle());
        }
    }
}