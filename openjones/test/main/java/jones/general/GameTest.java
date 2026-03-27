/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.jones.general;

import java.util.ArrayList;
import main.java.jones.actions.Action;
import main.java.jones.actions.ActionResponse;
import main.java.jones.map.MapManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Yasha
 */
public class GameTest {
    
    public static final int NOOP_ACTION_INDEX = -1;
    public final int MAX_PLAYERS = 4;
    public final static int TIMEUNITS_PER_WEEK = 600;
    public final static int TIMEUNITS_PER_HOUR = 5;
    private ArrayList<Player> _players;
    private EventManager _eventGen;
    private int _curPlayerIndex;
    private Player _curPlayer;
    //private boolean [] _hasWon; //true if player met his goals
    private int _clothesLevel;
    public final int MIN_PERIOD_BETWEEN_RENT_ANNOUNCEMENTS = 4;
    private boolean _hasStarted;
    private boolean _hasEnded;
    
    private ArrayList<Player> _victors; // = new ArrayList<>;
    private MapManager _map;
    private EconomyManager _economy; //holds a list of stocks and updates them
    private ArrayList<GameAnnouncement> _annoncments;
    private Action _weekendEvent;
    
    private MapManager mockMap;
    
    public GameTest() {
        mockMap = mock(MapManager.class);
        this._hasStarted = false;
        this._hasEnded = false;      
        
        if (null == mockMap) {
            _map = MapManager.getDefaultMap();
        } else {
            _map = mockMap;
        }

        _players = new ArrayList<>();
        _victors = new ArrayList<>();
        _eventGen = mock(EventManager.class);
        _economy = mock(ConstantEconomyModel.class);
        _curPlayerIndex = -1;
        _curPlayer = null;
        _annoncments = new ArrayList<>();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hasStarted method, of class Game.
     */
    @Test
    public void testHasStarted() {
        System.out.println("hasStarted");
        Game instance = new Game(mockMap);
        boolean expResult = false;
        boolean result = instance.hasStarted();
        assertEquals(expResult, result);
        instance.startGame();
        assertEquals(true, instance.hasStarted());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of hasEnded method, of class Game.
     */
    @Test
    public void testHasEnded() {
        System.out.println("hasEnded");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.hasEnded();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCurPlayer method, of class Game.
     */
    @Test
    public void testGetCurPlayer() {
        System.out.println("getCurPlayer");
        Game instance = null;
        Player expResult = null;
        Player result = instance.getCurPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasAnnouncements method, of class Game.
     */
    @Test
    public void testHasAnnouncements() {
        System.out.println("hasAnnouncements");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.hasAnnouncements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnnouncements method, of class Game.
     */
    @Test
    public void testGetAnnouncements() {
        System.out.println("getAnnouncements");
        Game instance = null;
        ArrayList<GameAnnouncement> expResult = null;
        ArrayList<GameAnnouncement> result = instance.getAnnouncements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlayer method, of class Game.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Player p = null;
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.addPlayer(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movePlayer method, of class Game.
     */
    @Test
    public void testMovePlayer() {
        System.out.println("movePlayer");
        PlayerPosition pos = null;
        Game instance = null;
        ActionResponse expResult = null;
        ActionResponse result = instance.movePlayer(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterBuilding method, of class Game.
     */
    @Test
    public void testEnterBuilding() {
        System.out.println("enterBuilding");
        Game instance = null;
        instance.enterBuilding();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leaveBuilding method, of class Game.
     */
    @Test
    public void testLeaveBuilding() {
        System.out.println("leaveBuilding");
        Game instance = null;
        instance.leaveBuilding();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endTurn method, of class Game.
     */
    @Test
    public void testEndTurn() {
        System.out.println("endTurn");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.endTurn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performBuildingAction method, of class Game.
     */
    @Test
    public void testPerformBuildingAction() {
        System.out.println("performBuildingAction");
        int actionIndex = 0;
        ArrayList<Action> possibleActions = null;
        Game instance = null;
        ActionResponse expResult = null;
        ActionResponse result = instance.performBuildingAction(actionIndex, possibleActions);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasTime method, of class Game.
     */
    @Test
    public void testHasTime() {
        System.out.println("hasTime");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.hasTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPossibletActions method, of class Game.
     */
    @Test
    public void testGetPossibletActions() {
        System.out.println("getPossibletActions");
        Game instance = null;
        ArrayList<Action> expResult = null;
        ArrayList<Action> result = instance.getPossibletActions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class Game.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Game instance = null;
        int expResult = 0;
        int result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeek method, of class Game.
     */
    @Test
    public void testGetWeek() {
        System.out.println("getWeek");
        Game instance = null;
        int expResult = 0;
        int result = instance.getWeek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Game instance = null;
        boolean expResult = false;
        boolean result = instance.isInside();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startGame method, of class Game.
     */
    @Test
    public void testStartGame() {
        System.out.println("startGame");
        Game instance = null;
        instance.startGame();
//        instance.
//        assertEquals()
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayers method, of class Game.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        Game instance = null;
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayers method, of class Game.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        ArrayList<Player> players = null;
        Game instance = null;
        instance.setPlayers(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventGen method, of class Game.
     */
    @Test
    public void testGetEventGen() {
        System.out.println("getEventGen");
        Game instance = null;
        EventManager expResult = null;
        EventManager result = instance.getEventGen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventGen method, of class Game.
     */
    @Test
    public void testSetEventGen() {
        System.out.println("setEventGen");
        EventManager eventGen = null;
        Game instance = null;
        instance.setEventGen(eventGen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurPlayerIndex method, of class Game.
     */
    @Test
    public void testGetCurPlayerIndex() {
        System.out.println("getCurPlayerIndex");
        Game instance = null;
        int expResult = 0;
        int result = instance.getCurPlayerIndex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurPlayerIndex method, of class Game.
     */
    @Test
    public void testSetCurPlayerIndex() {
        System.out.println("setCurPlayerIndex");
        int curPlayerIndex = 0;
        Game instance = null;
        instance.setCurPlayerIndex(curPlayerIndex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClothesLevel method, of class Game.
     */
    @Test
    public void testGetClothesLevel() {
        System.out.println("getClothesLevel");
        Game instance = null;
        int expResult = 0;
        int result = instance.getClothesLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClothesLevel method, of class Game.
     */
    @Test
    public void testSetClothesLevel() {
        System.out.println("setClothesLevel");
        int clothesLevel = 0;
        Game instance = null;
        instance.setClothesLevel(clothesLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVictors method, of class Game.
     */
    @Test
    public void testGetVictors() {
        System.out.println("getVictors");
        Game instance = null;
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = instance.getVictors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVictors method, of class Game.
     */
    @Test
    public void testSetVictors() {
        System.out.println("setVictors");
        ArrayList<Player> victors = null;
        Game instance = null;
        instance.setVictors(victors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMap method, of class Game.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        Game instance = null;
        MapManager expResult = null;
        MapManager result = instance.getMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMap method, of class Game.
     */
    @Test
    public void testSetMap() {
        System.out.println("setMap");
        MapManager map = null;
        Game instance = null;
        instance.setMap(map);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEconomy method, of class Game.
     */
    @Test
    public void testGetEconomy() {
        System.out.println("getEconomy");
        Game instance = null;
        EconomyManager expResult = null;
        EconomyManager result = instance.getEconomy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEconomy method, of class Game.
     */
    @Test
    public void testSetEconomy() {
        System.out.println("setEconomy");
        EconomyManager economy = null;
        Game instance = null;
        instance.setEconomy(economy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnnoncments method, of class Game.
     */
    @Test
    public void testGetAnnoncments() {
        System.out.println("getAnnoncments");
        Game instance = null;
        ArrayList<GameAnnouncement> expResult = null;
        ArrayList<GameAnnouncement> result = instance.getAnnoncments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnnoncments method, of class Game.
     */
    @Test
    public void testSetAnnoncments() {
        System.out.println("setAnnoncments");
        ArrayList<GameAnnouncement> annoncments = null;
        Game instance = null;
        instance.setAnnoncments(annoncments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeekendEvent method, of class Game.
     */
    @Test
    public void testGetWeekendEvent() {
        System.out.println("getWeekendEvent");
        Game instance = null;
        Action expResult = null;
        Action result = instance.getWeekendEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeekendEvent method, of class Game.
     */
    @Test
    public void testSetWeekendEvent() {
        System.out.println("setWeekendEvent");
        Action weekendEvent = null;
        Game instance = null;
        instance.setWeekendEvent(weekendEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAnnouncements method, of class Game.
     */
    @Test
    public void testGetAllAnnouncements() {
        System.out.println("getAllAnnouncements");
        Game instance = null;
        String expResult = "";
        String result = instance.getAllAnnouncements();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
