package codes.recursive.controller;

import codes.recursive.domain.Book;
import codes.recursive.repository.BookRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

@Controller("/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get(uri="/")
    public HttpResponse getBooks() {
        return HttpResponse.ok(
                bookRepository.findAll()
        );
    }

    @Get(uri = "/{bookId}")
    public HttpResponse getBook(ObjectId bookId) {
        return HttpResponse.ok( bookRepository.findById(bookId) );
    }

    @Post("/")
    public HttpResponse saveBook(@Body Book book) {
        bookRepository.save(book);
        return HttpResponse.created(book);
    }

    @Put("/")
    public HttpResponse updateBook(@Body Book book) {
        bookRepository.save(book);
        return HttpResponse.noContent();
    }

    @Delete("/{bookId}")
    public HttpResponse deleteBook(ObjectId bookId) {
        bookRepository.deleteById(bookId);
        return HttpResponse.noContent();
    }
}