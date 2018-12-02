package lambda.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ReduceMapDemo {
    public static void main(String[] args) {
        List<Book> books= new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        Book book2 = new Book();
        book2.setId(2);
        books.add(book1);
        books.add(book2);
        HashMap<Integer,Book> bookMap = books.stream().
                reduce(new HashMap<Integer, Book>(),
                        (map, book) ->{
                            map.put(book.getId(),book);
                            return map;
                        },
                        (map1, map2) -> {
                          map1.putAll(map2);
                          return map1;
                        });
        bookMap.forEach((k,v)-> System.out.println(k+":"+v));
    }
}

class Book{
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}

