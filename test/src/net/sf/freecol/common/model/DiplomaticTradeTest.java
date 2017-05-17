package net.sf.freecol.common.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sf.freecol.common.model.DiplomaticTrade.TradeContext;
import net.sf.freecol.common.model.DiplomaticTrade.TradeStatus;
import net.sf.freecol.common.model.TradeItem;
import net.sf.freecol.util.test.FreeColTestCase;

public class DiplomaticTradeTest extends FreeColTestCase{
	
	DiplomaticTrade test = null;
	Game gametest = getStandardGame("classic");
	TradeContext contexttest = null;
	Player sendertest = gametest.getPlayerByNationId("model.nation.dutch");;
	Player recepienttest = gametest.getPlayerByNationId("model.nation.dutch");;
	List<TradeItem> listtest = new ArrayList<>();
	int version = 0;
	//Player newrecepient = new Player(gametest);
	
	
	@Before
	public void setUp() throws Exception {
		test = new DiplomaticTrade(gametest,contexttest,sendertest,recepienttest,listtest,version);
		
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}


	@Test
	public void testGetContext() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(contexttest,test.getContext());
		
	}

	@Test
	public void testGetStatus() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(TradeStatus.PROPOSE_TRADE,test.getStatus());
	}

	@Test
	public void testSetStatus() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.setStatus(TradeStatus.ACCEPT_TRADE);;
		assertEquals(TradeStatus.ACCEPT_TRADE,test.getStatus());
	}

	@Test
	public void testGetSender() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(sendertest,test.getSender());
	}

	@Test
	public void testSetSender() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player send2 = gametest.getPlayerByNationId("model.nation.inca");
		test.setSender(send2);
		assertEquals(true,send2.equals(test.getSender()));
	}

	@Test
	public void testGetRecipient() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(recepienttest,test.getRecipient());
	}

	@Test
	public void testSetRecipient() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player testy = gametest.getPlayerByNationId("model.nation.dutch");
		test.setRecipient(testy);
		assertEquals(testy,test.getRecipient());
	}

	@Test
	public void testGetOtherPlayer() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(recepienttest,test.getOtherPlayer(sendertest));
		assertEquals(sendertest,test.getOtherPlayer(recepienttest));
	}


	@Test
	public void testAdd() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean found = false;
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		test.add(gold);
		List <TradeItem> list = test.getTradeItems();
		for(int i = 0; i < list.size(); i++){
			if(gold.equals(list.get(i)))
				found = true;
		}
		assertEquals(true,found);
	}

	@Test
	public void testRemoveTradeItem() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean found = false;
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		test.add(gold);
		test.remove(gold);
		List <TradeItem> list = test.getTradeItems();
		for(int i = 0; i < list.size(); i++){
			if(gold.equals(list.get(i)))
				found = true;
		}
		assertEquals(false,found);
	}
	

	@Test
	public void testRemoveInt() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean found = false;
		Player vil = new Player(gametest);
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		InciteTradeItem it = new InciteTradeItem(gametest,sendertest,recepienttest,vil);
		test.add(gold);
		test.add(it);
		test.remove(1);
		List <TradeItem> list = test.getTradeItems();
		for(int i = 0; i < list.size(); i++){
			if(it.equals(list.get(i)))
				found = true;
		}
		assertEquals(false,found);
	}

	@Test
	public void testRemoveType() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean found = false;
		Player vil = new Player(gametest);
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		InciteTradeItem it = new InciteTradeItem(gametest,sendertest,recepienttest,vil);
		test.add(gold);
		test.add(it);
		test.remove(1);
		List <TradeItem> list = test.getTradeItems();
		for(int i = 0; i < list.size(); i++){
			if(it.equals(list.get(i)))
				found = true;
		}
		assertEquals(false,found);
	}
	

	@Test
	public void testClear() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		test.add(gold);
		test.clear();
		assertEquals(true,test.isEmpty());
	}	

	@Test
	public void testGetTradeItems() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TradeItem> list = test.getTradeItems();
		assertEquals(list,test.getTradeItems());
	}

	@Test
	public void testIsEmpty() {
		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true,test.isEmpty());
	}

	@Test
	public void testIterator() {
		try{
		setUp();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		GoldTradeItem gold = new GoldTradeItem (gametest,sendertest,recepienttest,2);
		test.add(gold);
		Iterator<TradeItem> it = test.iterator();	
		boolean equal = true;
		while(it.hasNext()){
			  if(!it.next().equals(test.iterator().next())){
			    equal = false;
			    break;
			  }
			}
		assertEquals(true,equal);
	}

	@Test
	public void testGetItemsGivenBy() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gametest = getStandardGame("classic");
		Player se = gametest.getPlayerByNationId("model.nation.dutch");
		List<TradeItem> tii = test.getItemsGivenBy(se);
		assertEquals(tii,test.getTradeItems());
		
	}

	@Test
	public void testGetStance() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,test.getStance());
	}

	@Test
	public void testGetColoniesGivenBy() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Colony> li =new ArrayList<>();
		assertEquals(li,test.getColoniesGivenBy(sendertest));
	}

	@Test
	public void testGetGoldGivenBy() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(-1,test.getGoldGivenBy(sendertest));
	
	}

	@Test
	public void testGetGoodsGivenBy() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Goods> li =new ArrayList<>(); 
		assertEquals(li,test.getGoodsGivenBy(sendertest));
	
	
	}

	@Test
	public void testGetVictim() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null,test.getVictim());
	
	}

	@Test
	public void testGetUnitsGivenBy() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Unit> li = new ArrayList<>();
		assertEquals(li,test.getUnitsGivenBy(sendertest));
	}

	@Test
	public void testGetVersion() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,test.getVersion());
	}

	@Test
	public void testIncrementVersion() {
		try{
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.incrementVersion();
		assertEquals(1,test.getVersion());
	}

}
