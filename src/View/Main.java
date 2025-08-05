package View;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.application.Application;
import javafx.css.Size;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.text.Element;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.scene.image.Image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.characters.*;
import model.collectibles.Supply;
import model.collectibles.Vaccine;
import model.world.CharacterCell;
import model.world.CollectibleCell;
import model.world.TrapCell;

public class Main extends Application {

    static Stage window;
    static Scene scene1;
    Scene scene2;

    int size = 700;

    int NumoFCells = 15;
    int SizeOfCell = size / 15;
    Hero HeroInAction;
    Zombie Target;
    Hero healable;

    Rectangle[][] Grid = new Rectangle[NumoFCells][NumoFCells];


    Scene GameScene;

    BorderPane GameScenelayout = new BorderPane();

    public static void main(String[] args) {

        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {

        Game.loadHeroes("Heroes.csv");


        window = primaryStage;


        Label label1 = new Label("welcome to The Last of Us Legacy ");
        //Text text = new Text();
        // text.setText("hello");
        Button button1 = new Button("Start New Game");
        ;

        ////////////////////////////// Game Scene  ////////////////////////////

        BorderPane GameScenelayout = new BorderPane();
        VBox leftMenu = new VBox();
        leftMenu.setSpacing(40);
        Label buttonsLabel = new Label("Here are the buttons");

        Button AttakButton = new Button("Attack");
        Button CureButton = new Button("Cure");
        Button SpecialAttackButton = new Button("Use Special");
        leftMenu.getChildren().addAll(buttonsLabel, AttakButton, CureButton, SpecialAttackButton);

        GameScenelayout.setLeft(leftMenu);


        //   HBox bottomMenu = new HBox();

        //   bottomMenu.setSpacing(40);

        // Label InventoryLabel = new Label("Here is the Vaccine Inventory : " + Game.heroes.get(0).getVaccineInventory()  + "  and Supply Inventory : " + Game.heroes.get(0).getSupplyInventory());
        //move the Game scene to the button setonAction
        //  Label HeroInfo = new Label("The Heros Name : " + Game.availableHeroes.get(0).getName());
        // bottomMenu.getChildren().add(HeroInfo);
        //  GameScenelayout.setBottom(bottomMenu);


        Pane CenterMenu = new Pane();


        for (int i = 0; i < size - SizeOfCell; i += SizeOfCell) {

            for (int j = 0; j < size - SizeOfCell; j += SizeOfCell) {
                Rectangle ceR = new Rectangle(i, j, SizeOfCell, SizeOfCell);


                Grid[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] = ceR;


                ceR.setOnMousePressed(e -> {
                            System.out.println("X : " + ceR.getX() / SizeOfCell);
                            System.out.println("Y : " + ceR.getY() / SizeOfCell);
                        }
                );


                ceR.setFill(Color.BLANCHEDALMOND);
                ceR.setStroke(Color.PINK);
                CenterMenu.getChildren().add(ceR);


            }

        }


        GameScenelayout.setCenter(CenterMenu);
        GameScene = new Scene(GameScenelayout, 800, 800);


        ////////////////////////////// Hero Buttons
        Button buttonHero1 = new Button("First selectble Hero : " + " " + Game.availableHeroes.get(0).getName());
        Button buttonHero2 = new Button("second selectble Hero : " + " " + Game.availableHeroes.get(1).getName());
        Button buttonHero3 = new Button("Third selectble Hero : " + " " + Game.availableHeroes.get(2).getName());
        Button buttonHero4 = new Button("Fourth selectble Hero : " + " " + Game.availableHeroes.get(3).getName());
        Button buttonHero5 = new Button("Fifth selectble Hero : " + " " + Game.availableHeroes.get(4).getName());
        Button buttonHero6 = new Button("Sixth selectble Hero : " + Game.availableHeroes.get(5).getName());
        Button buttonHero7 = new Button("Seventh selectble Hero : " + Game.availableHeroes.get(6).getName());
        Button buttonHero8 = new Button("Eighth selectble Hero : " + " " + Game.availableHeroes.get(7).getName());

        /////////////////////////// labelHero
        Label labelHero1 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(0).getName());
        Label labelHero2 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(1).getName());
        Label labelHero3 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(2).getName());
        Label labelHero4 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(3).getName());
        Label labelHero5 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(4).getName());
        Label labelHero6 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(5).getName());
        Label labelHero7 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(6).getName());
        Label labelHero8 = new Label("You Have chosen " + "  " + Game.availableHeroes.get(7).getName());
////////////////////////// play Buttons
        Button startGame1 = new Button("Play");


        startGame1.setOnAction(e -> {

            Fighter hero1 = (Fighter) Game.availableHeroes.get(0);

            try {
                StartMap(hero1);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }

            window.setScene(GameScene);
            window.setFullScreen(true);


        });

        Button startGame2 = new Button("Play");
        startGame2.setOnAction(e -> {
            Medic hero2 = (Medic) Game.availableHeroes.get(1);

            try {
                StartMap(hero2);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }

            window.setScene(GameScene);
            window.setFullScreen(true);


        });


        Button startGame3 = new Button("Play");
        startGame3.setOnAction(e -> {
            Explorer hero3 = (Explorer) Game.availableHeroes.get(2);
            try {
                StartMap(hero3);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }

            window.setScene(GameScene);
            window.setFullScreen(true);


        });

        Button startGame4 = new Button("Play");
        startGame4.setOnAction(e -> {
            Explorer hero4 = (Explorer) Game.availableHeroes.get(3);
            try {
                StartMap(hero4);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }

            window.setScene(GameScene);
            window.setFullScreen(true);


        });

        Button startGame5 = new Button("Play");
        startGame5.setOnAction(e -> {
            Explorer hero5 = (Explorer) Game.availableHeroes.get(4);
            try {
                StartMap(hero5);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }
            window.setScene(GameScene);
            window.setFullScreen(true);


        });

        Button startGame6 = new Button("Play");
        startGame6.setOnAction(e -> {
            Medic hero6 = (Medic) Game.availableHeroes.get(5);

            try {
                StartMap(hero6);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());

                throw new RuntimeException(ex);
            }
            window.setScene(GameScene);
            window.setFullScreen(true);


        });

        Button startGame7 = new Button("Play");
        startGame7.setOnAction(e -> {
            Fighter hero7 = (Fighter) Game.availableHeroes.get(6);
            try {
                StartMap(hero7);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }
            window.setScene(GameScene);
            window.setFullScreen(true);


        });
        Button startGame8 = new Button("Play");
        startGame8.setOnAction(e -> {
            Medic hero8 = (Medic) Game.availableHeroes.get(7);
            try {
                StartMap(hero8);
            } catch (FileNotFoundException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            }

            window.setScene(GameScene);
            window.setFullScreen(true);


        });
        ////////////////// Go Back to the Selection Menu
        Button GoBackToselctingHeros1 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros2 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros3 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros4 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros5 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros6 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros7 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);
        Button GoBackToselctingHeros8 = new Button("Go back to Heroes selection menu");
        window.setFullScreen(true);

        Pane emptyPane = new Pane();

        // Button GoBackSelectHero = new Button("Go back to heroes selection menu");
        GoBackToselctingHeros1.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));


        GoBackToselctingHeros2.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros3.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros4.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros5.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros6.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros7.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));

        GoBackToselctingHeros8.setOnAction((e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        }));


/////////////////////////////
        BorderPane layoutHero1 = new BorderPane();
        BorderPane layoutHero2 = new BorderPane();
        BorderPane layoutHero3 = new BorderPane();
        BorderPane layoutHero4 = new BorderPane();
        BorderPane layoutHero5 = new BorderPane();
        BorderPane layoutHero6 = new BorderPane();
        BorderPane layoutHero7 = new BorderPane();
        BorderPane layoutHero8 = new BorderPane();


        layoutHero1.setPadding(new Insets(10));
        HBox bottomPane1 = new HBox();
        bottomPane1.setSpacing(1150);

        bottomPane1.getChildren().addAll(GoBackToselctingHeros1, startGame1);
        layoutHero1.setBottom(bottomPane1);


        Label HeroDetails1 = new Label(Game.availableHeroes.get(0).getName() + " " + " is  a " + "Fighter \n" + "The Attack Dmg : " + " " + Game.availableHeroes.get(0).getAttackDmg() + "\n" + "His MaxHp: " + "  " + Game.availableHeroes.get(0).getMaxHp() + "\n" + " The action points : " + Game.availableHeroes.get(0).getActionsAvailable());
        HeroDetails1.setFont(Font.font(40));
        //centerPane.getChildren().add(HeroDetails1);
        layoutHero1.setCenter(HeroDetails1);

///////////////////////////////////////////////////////////


        layoutHero2.setPadding(new Insets(10));
        HBox bottomPane2 = new HBox();
        bottomPane2.setSpacing(1150);

        bottomPane2.getChildren().addAll(GoBackToselctingHeros2, startGame2);
        layoutHero2.setBottom(bottomPane2);


        Label HeroDetails2 = new Label(Game.availableHeroes.get(1).getName() + " " + " is  a " + "Medic \n" + "The Attack Dmg : " + " " + Game.availableHeroes.get(1).getAttackDmg() + "\n" + "Her MaxHp: " + "  " + Game.availableHeroes.get(1).getMaxHp() + "\n" + " The action points  : " + Game.availableHeroes.get(1).getActionsAvailable());
        HeroDetails2.setFont(Font.font(40));
        layoutHero2.setCenter(HeroDetails2);

///////////////////////////////////////////////////
        layoutHero3.setPadding(new Insets(10));
        HBox bottomPane3 = new HBox();
        bottomPane3.setSpacing(1150);

        bottomPane3.getChildren().addAll(GoBackToselctingHeros3, startGame3);
        layoutHero3.setBottom(bottomPane3);


        Label HeroDetails3 = new Label(Game.availableHeroes.get(2).getName() + " " + " is  an " + "Explorer \n" + "The Attack Dmg : " + " " + Game.availableHeroes.get(2).getAttackDmg() + "\n" + "Her MaxHp: " + "  " + Game.availableHeroes.get(2).getMaxHp() + "\n" + " The action points  : " + Game.availableHeroes.get(2).getActionsAvailable());
        HeroDetails3.setFont(Font.font(40));
        layoutHero3.setCenter(HeroDetails3);

////////////////////////////////////////////////////////////
        layoutHero4.setPadding(new Insets(10));
        HBox bottomPane4 = new HBox();
        bottomPane4.setSpacing(1150);

        bottomPane4.getChildren().addAll(GoBackToselctingHeros4, startGame4);
        layoutHero4.setBottom(bottomPane4);

        HBox centerPane4 = new HBox();

        Label HeroDetails4 = new Label(Game.availableHeroes.get(3).getName() + " " + " is  a " + "Explorer \n" + "The Attack Dmg" + " " + Game.availableHeroes.get(3).getAttackDmg() + "\n" + "Her MaxHp: " + "  " + Game.availableHeroes.get(3).getMaxHp() + "\n" + " The action points: " + Game.availableHeroes.get(3).getActionsAvailable());
        HeroDetails4.setFont(Font.font(40));

        layoutHero4.setCenter(HeroDetails4);
///////////////////////////////////////////
        layoutHero5.setPadding(new Insets(10));
        HBox bottomPane5 = new HBox();
        bottomPane5.setSpacing(1150);

        bottomPane5.getChildren().addAll(GoBackToselctingHeros5, startGame5);
        layoutHero5.setBottom(bottomPane5);

        HBox centerPane5 = new HBox();

        Label HeroDetails5 = new Label(Game.availableHeroes.get(4).getName() + " " + " is  a " + "Explorer \n" + "The Attack Dmg" + " " + Game.availableHeroes.get(4).getAttackDmg() + "\n" + "His MaxHp: " + "  " + Game.availableHeroes.get(4).getMaxHp() + "\n" + " The action points  : " + Game.availableHeroes.get(4).getActionsAvailable());
        HeroDetails5.setFont(Font.font(40));
        //centerPane.getChildren().add(HeroDetails1);
        layoutHero5.setCenter(HeroDetails5);
////////////////////////////////////////////////////////
        layoutHero6.setPadding(new Insets(10));
        HBox bottomPane6 = new HBox();
        bottomPane6.setSpacing(1150);

        bottomPane6.getChildren().addAll(GoBackToselctingHeros6, startGame6);
        layoutHero6.setBottom(bottomPane6);


        Label HeroDetails6 = new Label(Game.availableHeroes.get(5).getName() + " " + " is  a " + "Medic \n" + "The Attack Dmg" + " " + Game.availableHeroes.get(5).getAttackDmg() + "\n" + "His MaxHp: " + "  " + Game.availableHeroes.get(5).getMaxHp() + "\n" + " The action points  : " + Game.availableHeroes.get(5).getActionsAvailable());
        HeroDetails6.setFont(Font.font(40));

        layoutHero6.setCenter(HeroDetails6);
        ///////////////////////////////////////////////////////

        layoutHero7.setPadding(new Insets(10));
        HBox bottomPane7 = new HBox();
        bottomPane7.setSpacing(1150);

        bottomPane7.getChildren().addAll(GoBackToselctingHeros7, startGame7);
        layoutHero7.setBottom(bottomPane7);


        Label HeroDetails7 = new Label(Game.availableHeroes.get(6).getName() + " " + " is  a " + "Fighter \n" + "The Attack Dmg" + " " + Game.availableHeroes.get(6).getAttackDmg() + "\n" + "His MaxHp: " + "  " + Game.availableHeroes.get(6).getMaxHp() + "\n" + " The action points  : " + Game.availableHeroes.get(6).getActionsAvailable());
        HeroDetails7.setFont(Font.font(40));

        layoutHero7.setCenter(HeroDetails7);
///////////////////////////////////////////////////////

        layoutHero8.setPadding(new Insets(10));

        HBox bottomPane8 = new HBox();

        bottomPane8.setSpacing(1150);

        bottomPane8.getChildren().addAll(GoBackToselctingHeros8, startGame8);
        layoutHero8.setBottom(bottomPane8);


        Label HeroDetails8 = new Label(Game.availableHeroes.get(7).getName() + " " + " is  a " + "Medic \n" + "The Attack Dmg" + " " + Game.availableHeroes.get(7).getAttackDmg() + "\n" + "His MaxHp: " + "  " + Game.availableHeroes.get(7).getMaxHp() + "\n" + " The action points : " + Game.availableHeroes.get(7).getActionsAvailable());
        HeroDetails8.setFont(Font.font(40));

        layoutHero8.setCenter(HeroDetails8);


//////////////////////////////////////////////////

        Scene sceneHero1 = new Scene(layoutHero1, 400, 300);
        Scene sceneHero2 = new Scene(layoutHero2, 400, 400);
        Scene sceneHero3 = new Scene(layoutHero3, 400, 400);
        Scene sceneHero4 = new Scene(layoutHero4, 400, 400);
        Scene sceneHero5 = new Scene(layoutHero5, 400, 400);
        Scene sceneHero6 = new Scene(layoutHero6, 400, 400);
        Scene sceneHero7 = new Scene(layoutHero7, 400, 400);
        Scene sceneHero8 = new Scene(layoutHero8, 400, 400);


        buttonHero1.setOnAction(e -> {
            window.setScene(sceneHero1);
            window.setFullScreen(true);
        });

        buttonHero2.setOnAction(e -> {
            window.setScene(sceneHero2);
            window.setFullScreen(true);
        });
        buttonHero3.setOnAction(e -> {
            window.setScene(sceneHero3);
            window.setFullScreen(true);
        });
        buttonHero4.setOnAction(e -> {
            window.setScene(sceneHero4);
            window.setFullScreen(true);
        });
        buttonHero5.setOnAction(e -> {
            window.setScene(sceneHero5);
            window.setFullScreen(true);
        });
        buttonHero6.setOnAction(e -> {
            window.setScene(sceneHero6);
            window.setFullScreen(true);
        });
        buttonHero7.setOnAction(e -> {
            window.setScene(sceneHero7);
            window.setFullScreen(true);
        });
        buttonHero8.setOnAction(e -> {
            window.setScene(sceneHero8);
            window.setFullScreen(true);
        });
//////////////////////////////////////////
        //The Game Scene


        button1.setOnAction(e -> {
            window.setScene(scene2);
            window.setFullScreen(true);
        });


        //Layout 1 = children out laid in vertical column

        BorderPane layout1 = new BorderPane();
        InputStream stream = new FileInputStream("\\Users\\Hazem\\Downloads\\wallpaperflare.com_wallpaper (12).jpg");

        Image image = new Image(stream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        layout1.getChildren().addAll(label1, button1);

        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitWidth(1800);
        imageView.setPreserveRatio(true);

        Group root = new Group(imageView);
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(root, button1);

        Scene scene = new Scene(layout2, 400, 400);
        primaryStage.setTitle("The Last of Us Legacy");
        primaryStage.setScene(scene);
        primaryStage.show();


        //scene1 = new Scene(layout1,200,200);

        //Button 2
        Label label2 = new Label("Welcome to our Game please choose your Hero");

        window.setFullScreen(true);


        //Layout 2

        VBox layout3 = new VBox(20);

        layout3.getChildren().addAll(label2, buttonHero1, buttonHero2, buttonHero3, buttonHero4, buttonHero5, buttonHero6, buttonHero7, buttonHero8);
        scene2 = new Scene(layout3, 400, 400);

        //window.setScene(scene1);
        // window.setTitle("Titile here");
        //   window.show();


    }


    public void StartMap(Hero hero) throws FileNotFoundException {
        HeroInAction = hero;
        Game.startGame(hero);
        RefreshMap();


        GameScene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            if (key.getCode() == KeyCode.W) {
                try {
                    int x = HeroInAction.getLocation().x;
                    int y = HeroInAction.getLocation().y;
                   if( y+1 <15 && Game.map[x][y+1] instanceof TrapCell)
                       Box.displayTrap();
                    HeroInAction.move(Direction.RIGHT);




                    Refresh();
                    setHeroLabel();

                    System.out.println("X :" + HeroInAction.getLocation().getX());
                    System.out.println("Y:" + HeroInAction.getLocation().getY());


                } catch (MovementException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);

                } catch (NotEnoughActionsException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);

                } catch (FileNotFoundException e) {
                    Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                    throw new RuntimeException(e);
                }


            }

            if (key.getCode() == KeyCode.A) {
                try {
                    int x = HeroInAction.getLocation().x;
                    int y = HeroInAction.getLocation().y;

                    if ( x-1 >-1 && Game.map[x-1][y] instanceof TrapCell)
                        Box.displayTrap();

                    HeroInAction.move(Direction.DOWN);
                    Refresh();
                    setHeroLabel();
                } catch (MovementException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (FileNotFoundException e) {
                    Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                    throw new RuntimeException(e);
                }


            }
            if (key.getCode() == KeyCode.D) {
                try {
                    int x = HeroInAction.getLocation().x;
                    int y = HeroInAction.getLocation().y;
                    if ( x+1 <15 && Game.map[x+1][y] instanceof TrapCell)
                        Box.displayTrap();

                    HeroInAction.move(Direction.UP);

                    Refresh();
                    setHeroLabel();
                } catch (MovementException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (FileNotFoundException e) {
                    Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                    throw new RuntimeException(e);
                }


            }

            if (key.getCode() == KeyCode.S) {
                try {
                    int x = HeroInAction.getLocation().x;
                    int y = HeroInAction.getLocation().y;
                    if ( y-1 >-1 && Game.map[x][y-1] instanceof TrapCell)
                        Box.displayTrap();
                    HeroInAction.move(Direction.LEFT);
                    Refresh();
                    setHeroLabel();
                } catch (MovementException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (NotEnoughActionsException ex) {
                    Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (FileNotFoundException e) {
                    Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                    throw new RuntimeException(e);
                }


            }


        });


    }

    public void Refresh() throws FileNotFoundException {

        int x = HeroInAction.getLocation().x;
        int y = HeroInAction.getLocation().y;
        InputStream stream = new FileInputStream("\\Users\\Hazem\\Downloads\\wallpaperflare.com_wallpaper (12).jpg");

        Image imj = new Image(stream);
        Grid[x][y].setFill(new ImagePattern(imj));

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i < 15 && x + i > -1 && y + j < 15 && y + j > -1) {
                    if (Game.map[x + i][y + j] instanceof CharacterCell && ((CharacterCell) Game.map[x + i][y + j]).getCharacter() == null) {
                        Grid[x + i][y + j].setFill(Color.WHITE);
                        Grid[x + i][y + j].setStroke(Color.BLACK);

                    } else if (Game.map[x + i][y + j] instanceof CharacterCell && ((CharacterCell) Game.map[x + i][y + j]).getCharacter() instanceof Zombie) {
                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\Zombie.jpeg");

                        Image IMJ = new Image(streamZ);
                        Grid[x + i][y + j].setFill(new ImagePattern(IMJ));
                        Grid[x + i][y + j].setStroke(Color.BLACK);
                    } else if (Game.map[x + i][y + j] instanceof CollectibleCell && ((CollectibleCell) Game.map[x + i][y + j]).getCollectible() instanceof Supply) {
                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\Supply.jpeg");

                        Image IMJ = new Image(streamZ);
                        Grid[x + i][y + j].setFill(new ImagePattern(IMJ));
                        Grid[x + i][y + j].setStroke(Color.BLACK);
                    } else if (Game.map[x + i][y + j] instanceof CollectibleCell && ((CollectibleCell) Game.map[x + i][y + j]).getCollectible() instanceof Vaccine) {

                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\Vaccine.png");

                        Image IMJ = new Image(streamZ);
                        Grid[x + i][y + j].setFill(new ImagePattern(IMJ));
                        Grid[x + i][y + j].setStroke(Color.BLACK);

                    } else if (Game.map[x + i][y + j] instanceof CharacterCell && ((CharacterCell) Game.map[x + i][y + j]).getCharacter() instanceof Hero) {
                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\wallpaperflare.com_wallpaper (12).jpg");

                        Image IMJ = new Image(streamZ);
                        Grid[x + i][y + j].setFill(new ImagePattern(IMJ));
                        Grid[x + i][y + j].setStroke(Color.BLACK);


                    } else {
                        Grid[x + i][y + j].setFill(Color.WHITE);
                        Grid[x + i][y + j].setStroke(Color.BLACK);
                    }

                }


            }
        }


    }


    public void RefreshMap() throws FileNotFoundException {

        VBox leftMenu = new VBox();
        leftMenu.setSpacing(40);

        Label buttonsLabel = new Label("Here are the buttons");

        Button AttakButton = new Button("Attack");
        Button CureButton = new Button("Cure");
        Button SpecialAttackButton = new Button("Use Special");

        Button EndTrun = new Button("End Turn");

        leftMenu.getChildren().addAll(buttonsLabel, AttakButton, CureButton, SpecialAttackButton, EndTrun);

        GameScenelayout.setLeft(leftMenu);

        Pane CenterMenu = new Pane();


        for (int i = 0; i < size - SizeOfCell; i += SizeOfCell) {

            for (int j = 0; j < size - SizeOfCell; j += SizeOfCell) {
                Rectangle ceR = new Rectangle(i, j, SizeOfCell, SizeOfCell);


                Grid[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] = ceR;


                ceR.setOnMousePressed(e -> {


                    int x = (int) ceR.getX() / SizeOfCell;
                    int y = (int) Math.abs(14 - ceR.getY() / SizeOfCell);

                    if (Game.map[x][y] instanceof CharacterCell && (((CharacterCell) Game.map[x][y]).getCharacter() instanceof Hero && HeroInAction instanceof Medic && HeroInAction.isSpecialAction())) {
                        healable = (Hero) ((CharacterCell) Game.map[x][y]).getCharacter();
                        HeroInAction.setTarget(healable);
                    } else if (Game.map[x][y] instanceof CharacterCell && (((CharacterCell) Game.map[x][y]).getCharacter() instanceof Hero)) {

                        HeroInAction = (Hero) ((CharacterCell) Game.map[x][y]).getCharacter();
                        setHeroLabel();
                    } else if (Game.map[x][y] instanceof CharacterCell && (((CharacterCell) Game.map[x][y]).getCharacter() instanceof Zombie)) {
                        HeroInAction.setTarget(((CharacterCell) Game.map[x][y]).getCharacter());


                    }


                });

                if (Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)].isVisible()) {

                    if ((Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] instanceof CharacterCell) && (((CharacterCell) Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)]).getCharacter() instanceof Hero)) {


                        InputStream stream = new FileInputStream("\\Users\\Hazem\\Downloads\\wallpaperflare.com_wallpaper (12).jpg");

                        Image imj = new Image(stream);
                        ceR.setFill(new ImagePattern(imj));

                    } else if ((Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] instanceof CharacterCell) && ((CharacterCell) Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)]).getCharacter() == null) {

                        ceR.setFill(Color.WHITE);
                        ceR.setStroke(Color.BLACK);

                    } else if ((Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] instanceof CharacterCell) && ((CharacterCell) Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)]).getCharacter() instanceof Zombie) {

                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\Zombie.jpeg");

                        Image IMJ = new Image(streamZ);
                        ceR.setFill(new ImagePattern(IMJ));
                        ceR.setStroke(Color.BLACK);

                    } else if ((Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] instanceof CollectibleCell) && ((CollectibleCell) Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)]).getCollectible() instanceof Supply) {

                        InputStream streamS = new FileInputStream("\\Users\\Hazem\\Downloads\\Supply.jpeg");

                        Image IMJ = new Image(streamS);
                        ceR.setFill(new ImagePattern(IMJ));
                        ceR.setStroke(Color.BLACK);
                    } else if ((Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)] instanceof CollectibleCell) && ((CollectibleCell) Game.map[i / SizeOfCell][Math.abs(14 - j / SizeOfCell)]).getCollectible() instanceof Vaccine) {
                        InputStream streamS = new FileInputStream("\\Users\\Hazem\\Downloads\\Vaccine.png");

                        Image IMJ = new Image(streamS);
                        ceR.setFill(new ImagePattern(IMJ));
                        ceR.setStroke(Color.BLACK);

                    } else {

                        ceR.setFill(Color.WHITE);
                        ceR.setStroke(Color.BLACK);

                    }

                }

                // }
                //else {


                // }
                CenterMenu.getChildren().add(ceR);

            }


        }


        GameScenelayout.setCenter(CenterMenu);
        HBox bottomMenu = new HBox();
        HBox RightMenu = new HBox();

        Label HeroInActionInfo = new Label("The Hero in Action : " + "\n" + "The Heros Name : " + HeroInAction.getName() + "\n"    + "Type : " + HeroInAction.getClass() + "\n " + " Current Hp : " + HeroInAction.getCurrentHp() + " \n" + " Action poins : " + HeroInAction.getActionsAvailable() + "\n" + " Attack Damage : " + HeroInAction.getAttackDmg() + "\n" + "Picked Up Supplies : " + HeroInAction.getSupplyInventory().size() + "\n" + "Picked Up vaccines : " + HeroInAction.getVaccineInventory().size());
        HeroInActionInfo.setFont(Font.font(30));
        RightMenu.getChildren().add(HeroInActionInfo);
        RightMenu.setSpacing(30);
        bottomMenu.setSpacing(30);

        for (int i = 0; i < Game.heroes.size(); i++) {
            Label HeroInfo = new Label("The Heros Name : " + Game.heroes.get(i).getName() + "\n" + "Type : " + Game.heroes.get(i).getClass() + "\n " + " Current Hp : "  +  Game.heroes.get(i).getCurrentHp() + " \n" + " Action poins : " + Game.heroes.get(i).getActionsAvailable() + "\n" + " Attack Damage : " + Game.heroes.get(i).getAttackDmg() + "\n" + "Picked Up Supplies : " + Game.heroes.get(i).getSupplyInventory().size() + "\n" + "Picked Up vaccines : " + Game.heroes.get(i).getVaccineInventory().size());


            bottomMenu.getChildren().add(HeroInfo);

        }

        GameScenelayout.setBottom(bottomMenu);
        GameScenelayout.setRight(RightMenu);

        GameScene = new Scene(GameScenelayout, 800, 800);


        AttakButton.setOnAction(E -> {
            try {
                Check();
                HeroInAction.attack();
                Refresh();
                setHeroLabel();

            } catch (NotEnoughActionsException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (InvalidTargetException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (FileNotFoundException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                throw new RuntimeException(e);
            }


        });

        CureButton.setOnAction(E -> {
            try {
                Check();
                HeroInAction.cure();
                Refresh();
                setHeroLabel();
                Check();

            } catch (NoAvailableResourcesException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (InvalidTargetException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (NotEnoughActionsException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (FileNotFoundException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                throw new RuntimeException(e);
            }

        });


        SpecialAttackButton.setOnAction(E -> {

            try {
                Check();
                if (HeroInAction instanceof Medic)
                    SearchForMedic();

                HeroInAction.useSpecial();
                RefreshEndTurn();
                setHeroLabel();
                Check();
            }
            catch (NoAvailableResourcesException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);

            }
            catch (InvalidTargetException ex) {
                Box.displayMove(String.valueOf(ex.getCause()),ex.getMessage());
                throw new RuntimeException(ex);
            } catch (FileNotFoundException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                throw new RuntimeException(e);
            }


        });

        EndTrun.setOnAction(E -> {
            try {
                Check();
                Game.endTurn();

                RefreshEndTurn();
                setHeroLabel();
                Check();

            } catch (NotEnoughActionsException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                throw new RuntimeException(e);
            } catch (InvalidTargetException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());

                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                Box.displayMove(String.valueOf(e.getCause()),e.getMessage());
                throw new RuntimeException(e);
            }
            ;

        });


    }


    public void RefreshEndTurn() throws FileNotFoundException {

        Check();
        // setHeroLabel();

        for (int i = 0; i < 15; i++) {

            for (int j = 0; j < 15; j++) {

                if (Game.map[i][j].isVisible()) {

                    if ((Game.map[i][j] instanceof CharacterCell) && (((CharacterCell) Game.map[i][j]).getCharacter() instanceof Hero)) {


                        InputStream stream = new FileInputStream("\\Users\\Hazem\\Downloads\\wallpaperflare.com_wallpaper (12).jpg");

                        Image imj = new Image(stream);
                        Grid[i][j].setFill(new ImagePattern(imj));

                    } else if ((Game.map[i][j] instanceof CharacterCell && ((CharacterCell) Game.map[i][j]).getCharacter() == null)) {

                        Grid[i][j].setFill(Color.WHITE);
                        Grid[i][j].setStroke(Color.BLACK);

                    } else if (((Game.map[i][j] instanceof CharacterCell) && ((CharacterCell) Game.map[i][j]).getCharacter() instanceof Zombie)) {

                        InputStream streamZ = new FileInputStream("\\Users\\Hazem\\Downloads\\Zombie.jpeg");

                        Image IMJ = new Image(streamZ);
                        Grid[i][j].setFill(new ImagePattern(IMJ));
                        Grid[i][j].setStroke(Color.BLACK);

                    } else if ((Game.map[i][j] instanceof CollectibleCell) && ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Supply) {

                        InputStream streamS = new FileInputStream("\\Users\\Hazem\\Downloads\\Supply.jpeg");

                        Image IMJ = new Image(streamS);
                        Grid[i][j].setFill(new ImagePattern(IMJ));
                        Grid[i][j].setStroke(Color.BLACK);
                    } else if ((Game.map[i][j] instanceof CollectibleCell) && ((CollectibleCell) Game.map[i][j]).getCollectible() instanceof Vaccine) {
                        InputStream streamS = new FileInputStream("\\Users\\Hazem\\Downloads\\Vaccine.png");

                        Image IMJ = new Image(streamS);
                        Grid[i][j].setFill(new ImagePattern(IMJ));
                        Grid[i][j].setStroke(Color.BLACK);

                    } else {

                        Grid[i][j].setFill(Color.WHITE);
                        Grid[i][j].setStroke(Color.BLACK);

                    }

                } else {

                    Grid[i][j].setFill(Color.BLACK);
                    Grid[i][j].setStroke(Color.BLACK);

                }


            }


        }


    }


    public void setHeroLabel() {

        HBox RightMenu = new HBox();
        HBox bottomMenu = new HBox();

        Label HeroInActionInfo = new Label("The Hero in Action : " + "\n" + "The Heros Name : " + HeroInAction.getName() + "\n" +"Type : " + HeroInAction.getClass() + "\n " +   "\n" + " Current Hp : " + HeroInAction.getCurrentHp() + " \n" + " Action poins : " + HeroInAction.getActionsAvailable() + "\n" + " Attack Damage : " + HeroInAction.getAttackDmg() + "\n" + "Picked Up Supplies : " + HeroInAction.getSupplyInventory().size() + "\n" + "Picked Up vaccines : " + HeroInAction.getVaccineInventory().size());
        HeroInActionInfo.setFont(Font.font(30));
        RightMenu.getChildren().add(HeroInActionInfo);
        RightMenu.setSpacing(30);
        bottomMenu.setSpacing(30);

        for (int i = 0; i < Game.heroes.size(); i++) {
            Label HeroInfo = new Label("The Heros Name : " + Game.heroes.get(i).getName() + "\n" +"Type : " + HeroInAction.getClass() + "\n"  + " Current Hp : " + Game.heroes.get(i).getCurrentHp() + " \n" + " Max Action points : " + Game.heroes.get(i).getMaxActions() + "\n" + " Attack Damage : " + Game.heroes.get(i).getAttackDmg() + "\n" + "Picked Up Supplies : " + Game.heroes.get(i).getSupplyInventory().size() + "\n" + "Picked Up vaccines : " + Game.heroes.get(i).getVaccineInventory().size());

            bottomMenu.getChildren().add(HeroInfo);


        }
        GameScenelayout.setRight(RightMenu);
        GameScenelayout.setBottom(bottomMenu);

        GameScene = new Scene(GameScenelayout, 800, 800);


    }

    public void SearchForMedic() {
        int x = HeroInAction.getLocation().x;
        int y = HeroInAction.getLocation().y;

        if (x + 1 < 15 && y + 1 < 15) {
            if (Game.map[x + 1][y + 1] instanceof CharacterCell && ((CharacterCell) Game.map[x + 1][y + 1]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x + 1][y + 1]).getCharacter();
                HeroInAction.setTarget(healable);
                return;

            }

        }
        if (x + 1 < 15) {
            if (Game.map[x + 1][y] instanceof CharacterCell && ((CharacterCell) Game.map[x + 1][y]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x + 1][y]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }
        }
        if (x + 1 < 15 && y - 1 > -1) {
            if (Game.map[x + 1][y - 1] instanceof CharacterCell && ((CharacterCell) Game.map[x + 1][y - 1]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x + 1][y - 1]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }
        }
        if (x - 1 > -1 && y - 1 > -1) {

            if (Game.map[x - 1][y - 1] instanceof CharacterCell && ((CharacterCell) Game.map[x - 1][y - 1]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x - 1][y - 1]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }


        }

        if (x - 1 > -1) {
            if (Game.map[x - 1][y] instanceof CharacterCell && ((CharacterCell) Game.map[x - 1][y]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x - 1][y]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }


        }

     if(x-1 > -1 && y+1<15){
         if (Game.map[x - 1][y+1] instanceof CharacterCell && ((CharacterCell) Game.map[x - 1][y+1]).getCharacter() instanceof Hero) {
             healable = (Hero) ((CharacterCell) Game.map[x - 1][y+1]).getCharacter();
             HeroInAction.setTarget(healable);
             return;


         }



     }

        if(y+1<15){
            if (Game.map[x][y+1] instanceof CharacterCell && ((CharacterCell) Game.map[x][y+1]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x][y+1]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }



        }
        if(y-1>-1){
            if (Game.map[x][y-1] instanceof CharacterCell && ((CharacterCell) Game.map[x][y-1]).getCharacter() instanceof Hero) {
                healable = (Hero) ((CharacterCell) Game.map[x][y-1]).getCharacter();
                HeroInAction.setTarget(healable);
                return;


            }



        }

        healable = HeroInAction;
        HeroInAction.setTarget((healable));

    }




    public void Check(){
        if(Game.checkWin()){
            Box.displayWin();

        }
        else if(Game.checkGameOver()){
            Box.displayGameOver();
        }


    }



}














