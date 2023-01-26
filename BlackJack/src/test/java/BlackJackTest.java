import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest extends BlackJack {

    decks d=new decks();
    Cards c=new Cards();
    public static boolean start=true;
    public static List<String> ReturnCardList=new ArrayList<String>();
    public static int UpdatedTotal=0;
    @Test
    void testshuffle()
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
    @Test
    void testmain()
    {
        String s="n\ny\nn\ny\nn\ny\nn\nn\nn\nn\ny\ny\nn\ny";
        ByteArrayInputStream bais = new ByteArrayInputStream(s.getBytes());
        System.setIn(bais);
        BlackJack.main(new String[0]);
    }


}