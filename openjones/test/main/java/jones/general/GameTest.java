/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.jones.general;

import java.util.ArrayList;
import main.java.jones.actions.Action;
import main.java.jones.actions.ActionResponse;
import main.java.jones.map.House;
import main.java.jones.map.MapManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private Player testPlayer;
    private final Game gameInstance;
    
    private Player playerSpy = mock(Player.class);
    
    private static final Logger log = LoggerFactory.getLogger(GameTest.class);
    
    private MapManager realMap;
    private House lowestCostHousing;
    private Player realPlayer;
    
    public GameTest() {
        mockMap = mock(MapManager.class);
        testPlayer = mock(Player.class);
        
        realMap = MapManager.getDefaultMap();
        realPlayer = new Player("Real Player", null, realMap);
        gameInstance = new Game(mockMap);
        
//        _map = new MapManager();
//        testPlayer = new Player("TestPlayer", null, mockMap);
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
        boolean expResult = false;
        boolean result = gameInstance.hasStarted();
        assertEquals(expResult, result);
        assertEquals(gameInstance.hasEnded(), false);
        gameInstance.addPlayer(testPlayer);
        gameInstance.startGame();
        assertEquals(true, gameInstance.hasStarted());
    }

    /**
     * Test of hasEnded method, of class Game.
     */
    @Test
    public void testHasEnded() {
        System.out.println("hasEnded");
        assertEquals(gameInstance.hasStarted(), false);
        assertEquals(gameInstance.hasEnded(), false);
        gameInstance.addPlayer(playerSpy);
        gameInstance.startGame();
        Mockito.doReturn(true).when(playerSpy).hasWon();
        gameInstance.endTurn();
        boolean result = gameInstance.hasEnded();
        assertEquals(true, result);
    }

    /**
     * Test of getCurPlayer method, of class Game.
     */
    @Test
    public void testGetCurPlayer() {
        System.out.println("getCurPlayer");
        Player expResult = null;
        Player result = gameInstance.getCurPlayer();
        assertEquals(expResult, result);
        
        gameInstance.addPlayer(testPlayer);
        gameInstance.startGame();
        assertEquals(gameInstance.getCurPlayer(), testPlayer);
        Player player2 = gameInstance.getCurPlayer();
        
        gameInstance.endTurn();
        assertEquals(gameInstance.getCurPlayer(), player2);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * This tests announcements by ending a turn, and mocking the player 
     * state areClothesAboutToWare() so that an announcement is added 
     * "You need new clothes" to _announcements. It's a little bit of code 
     * manipulation because we don't have direct access for adding 
     * announcements.
     */
    @Test
    public void testHasAnnouncements() {
        System.out.println("hasAnnouncements");
        boolean expResult = false;
        boolean result = gameInstance.hasAnnouncements();
        assertEquals(expResult, result);
        
        gameInstance.addPlayer(playerSpy);
        Mockito.doReturn(true).when(playerSpy).areClothesAboutToWare();
        gameInstance.endTurn();
        assertEquals(gameInstance.hasAnnouncements(), true);
    }

    /**
     * Test of getAnnouncements method, slightly extended version of 
     * hasAnnouncements test
     */
    @Test
    public void testGetAnnouncements() {
        System.out.println("hasAnnouncements");
        boolean expResult = false;
        boolean result = gameInstance.hasAnnouncements();
        assertEquals(expResult, result);
        
        gameInstance.addPlayer(playerSpy);
        Mockito.doReturn(true).when(playerSpy).areClothesAboutToWare();
        gameInstance.endTurn();
        assertEquals(gameInstance.hasAnnouncements(), true);
        ArrayList<GameAnnouncement> announcementList = gameInstance.getAnnouncements();
        GameAnnouncement announcement = announcementList.get(0);
        System.out.println(String.format("Announcements contains: %s", announcement._msg));
        assertEquals(Constants.Announcements.NeedNewClothes, announcement._msg);
    }
    
        /**
     * Test of getAllAnnouncements method, of class Game. StartGame doesn't 
     * clear the announcements box (TODO -might need to fix that at some point)
     * so we can just add the same announcement twice. Makes sure that whole 
     * list is returned.
     */
    @Test
    public void testGetAllAnnouncements() {
        System.out.println("getAllAnnouncements");
        boolean expResult = false;
        boolean result = gameInstance.hasAnnouncements();
        assertEquals(expResult, result);
        
        gameInstance.addPlayer(playerSpy);
        gameInstance.startGame();
        Mockito.doReturn(true).when(playerSpy).areClothesAboutToWare();
        assertEquals(gameInstance.hasAnnouncements(), true);
        ArrayList<GameAnnouncement> announcementList = gameInstance.getAnnouncements();
        GameAnnouncement announcement = announcementList.get(0);
        assertEquals(Constants.Announcements.GoodLuck, announcement._msg);
        gameInstance.startGame();
        System.out.println(String.format("Announcements contains: %s", announcement._msg));
        assertEquals(announcementList.size(), 2);
    }

    /**
     * Test of addPlayer method, of class Game.
     */
    @Test
    public void testAddPlayer() {
        //Add player
        //succeeds because there's enough spots
        //Add 3 more players
        //Each operation should succeed until we try adding a 5th player
        boolean addSuccessful;
        for(int i = 0; i < 4; i++) {
            addSuccessful = gameInstance.addPlayer(testPlayer);
            assertEquals(addSuccessful, true);
        }
        addSuccessful = gameInstance.addPlayer(testPlayer);
        assertEquals(addSuccessful, false);
    }    

    /**
     * Test of endTurn method, of class Game.
     */
    @Test
    public void testEndTurn() {
        gameInstance.addPlayer(testPlayer);
        gameInstance.addPlayer(realPlayer);
        gameInstance.startGame();
        assertEquals(gameInstance.getCurPlayerIndex(), 0);
        GameAnnouncement goodLuck = gameInstance.getAnnouncements().get(0);
        assertEquals(Constants.Announcements.GoodLuck, goodLuck._msg);
        
        System.out.println("endTurn");
        gameInstance.endTurn();
        assertEquals(gameInstance.getCurPlayerIndex(), 1);
        assertEquals(gameInstance.hasAnnouncements(), false);

    }

    /**
     * Test of performBuildingAction method, of class Game.
     */
    @Test
    public void testPerformBuildingAction() {
        /**
         * Get the current player's state. The player should be inside a building.
         * We should know what that building is.
         * We perform the action. It should be one that returns an announcement.
         * We check for that announcement.
         * The return should be of type ActionResponse
         * 
         * Get player's current building. Sleep. Check that latest game 
         * announcement message is zzzzzz. Make sure that the result is what we
         * asked for (have to check how ActionResponse should look). Building
         * Action should return positive.
         * 
         * Go to QT Clothing. Buy all 3 clothing sets. By the 3rd set, the 
         * action shouldn't have been possible, and we should return negative.
         * 
         * Move player to another building. Do a building specific action.
         * Return positive (QT clothing? Buy first 2 things and get ok outcome.
         */
        gameInstance.addPlayer(testPlayer);
        gameInstance.addPlayer(realPlayer);
        gameInstance.startGame();
        
        gameInstance.performBuildingAction(0, realMap,)
        
        int actionIndex = 0;
        ArrayList<Action> possibleActions = null;
        ActionResponse expResult = null;
        ActionResponse result = gameInstance.performBuildingAction(actionIndex, possibleActions);
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
        boolean expResult = false;
        boolean result = gameInstance.hasTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPossibleActions method, of class Game.
     */
    @Test
    public void testGetPossibletActions() {
        System.out.println("getPossibletActions");
        ArrayList<Action> expResult = null;
        ArrayList<Action> result = gameInstance.getPossibleActions();
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
        int expResult = 0;
        int result = gameInstance.getTime();
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
        int expResult = 0;
        int result = gameInstance.getWeek();
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
        boolean expResult = false;
        boolean result = gameInstance.isInside();
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
        gameInstance.startGame();
//        gameInstance.
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
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = gameInstance.getPlayers();
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
        gameInstance.setPlayers(players);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventGen method, of class Game.
     */
    @Test
    public void testGetEventGen() {
        System.out.println("getEventGen");
        EventManager expResult = null;
        EventManager result = gameInstance.getEventGen();
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
        gameInstance.setEventGen(eventGen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurPlayerIndex method, of class Game.
     */
    @Test
    public void testGetCurPlayerIndex() {
        System.out.println("getCurPlayerIndex");
        int expResult = 0;
        int result = gameInstance.getCurPlayerIndex();
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
        gameInstance.setCurPlayerIndex(curPlayerIndex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClothesLevel method, of class Game.
     */
    @Test
    public void testGetClothesLevel() {
        System.out.println("getClothesLevel");
        int expResult = 0;
        int result = gameInstance.getClothesLevel();
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
        gameInstance.setClothesLevel(clothesLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVictors method, of class Game.
     */
    @Test
    public void testGetVictors() {
        System.out.println("getVictors");
        ArrayList<Player> expResult = null;
        ArrayList<Player> result = gameInstance.getVictors();
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
        gameInstance.setVictors(victors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMap method, of class Game.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        MapManager expResult = null;
        MapManager result = gameInstance.getMap();
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
        gameInstance.setMap(map);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    //TODO - Finish these tests once we've fully implemented these functions
    
    /**
     * Test of getEconomy method, of class Game.
     */
    @Test
    public void testGetEconomy() {
        System.out.println("getEconomy");
        Game gameInstance = null;
        EconomyManager expResult = null;
        EconomyManager result = gameInstance.getEconomy();
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
        gameInstance.setEconomy(economy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getAnnoncments method, of class Game.
     */
    @Test
    public void testGetAnnoncments() {
        System.out.println("getAnnoncments");
        ArrayList<GameAnnouncement> expResult = null;
        ArrayList<GameAnnouncement> result = gameInstance.getAnnouncments();
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
        gameInstance.setAnnouncments(annoncments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getWeekendEvent method, of class Game.
     */
    @Test
    public void testGetWeekendEvent() {
        System.out.println("getWeekendEvent");
        Action expResult = null;
        Action result = gameInstance.getWeekendEvent();
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
        gameInstance.setWeekendEvent(weekendEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testMovePlayer() {
        System.out.println("movePlayer");
        PlayerPosition pos = null;
        ActionResponse expResult = null;
        ActionResponse result = gameInstance.movePlayer(pos);
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
        gameInstance.addPlayer(testPlayer);
        gameInstance.enterBuilding();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leaveBuilding method, of class Game.
     */
    @Test
    public void testLeaveBuilding() {
        System.out.println("leaveBuilding");
        gameInstance.leaveBuilding();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
