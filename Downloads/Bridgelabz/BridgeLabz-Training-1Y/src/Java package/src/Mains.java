
   import com.gla.library.books.Book;
import com.gla.library.members.Member;
import com.gla.library.transactions.Transaction;

    public class Mains {
        public static void main(String[] args) {

            // 1. Add a new book
            Book book1 = new Book(101, "Java Programming", "James Gosling");
            book1.displayBook();

            // 2. Register a new member
            Member member1 = new Member(1, "Amit");
            member1.displayMember();

            // 3. Issue a book
            Transaction transaction = new Transaction();
            transaction.issueBook(book1, member1);
        }
    }

