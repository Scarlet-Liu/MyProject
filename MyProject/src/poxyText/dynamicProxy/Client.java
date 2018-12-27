package poxyText.dynamicProxy;

public class Client {

	public static void main(String[] args) {
		BookFacadeImpl bookimpl = new BookFacadeImpl();
		BookFacadeProxy poxy = new BookFacadeProxy();
		BookFacade  book =(BookFacade) poxy.bind(bookimpl);

		book.addBook();
	}

}
