package src;
//import java.util.Scanner;

public class Player {
    int playerId; 
    String name;
    Board board;
    int score;
    int x;
    int y;

    public Player(){
        //empty constructor
        playerId = 0;
        name = " ";
        score = 0;
        x = 0;
        y = 0;
    }
    public Player(int playerId, String name, int score, int x, int y, Board board){
        this.playerId = playerId;
        this.name = name;
        this.board = board;
        this.score = score;
        this.x = x;
        this.y = y;
    }
    public int getPlayerId(){
        return playerId;
    }
    public void setPlayerId(int playerId){
        this.playerId = playerId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Board getBoard(){
        return board; 
    }
    public void setBoard(Board board){
        this.board = board;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    public int[] mymove(int id) {
        int[] ret = new int[4];
        System.out.println("You can't move that way!");
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; // καθως δεν κουνηθηκε, δεν βρηκε καποιο supply, αρα το supply id = 0
        return ret;
    }

    public int[] mymoveelse(int id) {
        int[] ret = new int[4];
        ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; //δεν βρηκε supply
                if(board.tiles[id].getSupply() && name.equals("Theseus") && id != 0){
                    for(int i=0; i<board.getS(); i++){
                        if(board.supplies[i].getSupplyTileId() == id){
                            ret[3] = board.supplies[i].getSupplyId(); //βρηκε supply αρα κραταει το id του στην 4η θεση του πινακα
                            board.supplies[i].setX(0);
                            board.supplies[i].setY(0);                      //μηδενισμος των συντεταγμενων του supply που βρηκα
                            board.supplies[i].setSupplyTileId(0);
                            break;
                        }
                    }
                    board.tiles[id].setSupply(false);
                    System.out.println("You have found a supply with id: " + (ret[3] + 1));
                    setScore(getScore() + 1); //αυξανει το τωρινο σκορ κατα 1 αφου βρηκε supply
                }
        return ret;
    }

    public int[] move(int id){
        int direction = 2*(int)((Math.random()*100) % 4) + 1;
        /*Scanner scan = new Scanner(System.in);
        System.out.println("Enter direction(1, 3, 5, 7): ");
        int direction = scan.nextInt();*/
        switch(direction){
            case 1: System.out.println(); System.out.println(); System.out.println(getName() + " decided to move up."); break;
            case 2: break;
            case 3: System.out.println(); System.out.println(); System.out.println(getName() + " decided to move right."); break;
            case 4: break;
            case 5: System.out.println(); System.out.println(); System.out.println(getName() + " decided to move down."); break;
            case 6: break;
            case 7: System.out.println(); System.out.println(); System.out.println(getName() + " decided to move left."); break;
            default: break;
        }
        int[] ret = new int[4];
        if(direction == 1){
            if(board.tiles[id].getUp()){ //ελεγχος για εμποδιο μπροστα, ο τοιχος των οριων θεωρειται επισης εμποδιο!
                ret=mymove(id);
                } 
            else{
                this.x = this.x + 1;
                id = id + board.getN();
                ret=mymoveelse(id);
                }
        }
        else if(direction == 3){
            if(board.tiles[id].getRight()){ //ελεγχος για εμποδιο δεξια, ο τοιχος των οριων θεωρειται επισης εμποδιο
                ret=mymove(id);
                }   
            else{
                this.y = this.y + 1;
                id = id + 1;
                ret=mymoveelse(id);
            }
        }
        else if(direction == 5){
            if(board.tiles[id].getDown()){
                ret=mymove(id);
                } 
            else{
                this.x = this.x - 1;
                id = id - board.getN();
                ret=mymoveelse(id);
            }
        }
        else if(direction == 7){
            if(board.tiles[id].getLeft() || board.tiles[id].getY() == 0){
                ret=mymove(id);
                } 
            else{
                this.y = this.y - 1;
                id = id - 1;
                ret=mymoveelse(id);
            }
        }
        return ret;
    }

    
}
