import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {

    decks d=new decks();
    Cards c=new Cards();
    public static boolean start=true;
    public static List<String> ReturnCardList=new ArrayList<String>();
    public static int UpdatedTotal=0;
    @Test
    void main()
    {

        d.shuffle();
        List<String> list = d.getList();
        assertNotNull(list);
        ReturnCardList=c.CardValues(list, start, ReturnCardList, UpdatedTotal);
        assertNotNull(ReturnCardList);
        ReturnCardList.clear();
        ReturnCardList=c.CardValues(list, false, list, UpdatedTotal);
        assertNotNull(ReturnCardList);
    }

}