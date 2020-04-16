package lingnan.test;

import java.util.Date;


import lingnan.pojo.Book;
import lingnan.service.BookService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mybatisandspringtest {
@Test
public void t2() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
    BookService bookService = ctx.getBean("bookService", BookService.class);
//    int bean = userService.login("z001", "0.00.0");
//    System.out.println(bean);
    
//    User user=new User("fahaha","12212314",2,1);
//    System.out.println(userService.addUser(user));
//    User user=new User();
//    user.setName("fafafa");
//    user.setPassword("88888");
//    System.out.println(userService.updateUserByPassword(user));

//    Book book=new Book(1, 2, new Date(),new Date());
   System.out.println(1);
//    System.out.println(book.getBookDate());
    System.out.println(1);

//    System.out.println(book);
//    System.out.println(bookService.insertBook(book));
//    System.out.println(bookService.updateByBookId(book));
//    System.out.println(bookService.deleteByBoodId(6));
//    System.out.println(bookService.bookEnd(2));
//    System.out.println(bookService.getBookAllByStateNotZero());
//  System.out.println(bookService.getBookAllByState(0));
    System.out.println(bookService.getBookByBookId(5));
// System.out.println(userService.queryAll());   
//    System.out.println(bookService.getBookByBookId(1));
}
}
