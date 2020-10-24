package src;

public class Player {
    int playerId; 
    String name;
    Board board;
    int score;
    int x;
    int y;

    public Player(){
        //empty constructor
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

    public int[] move(int id){
        int direction = 2*(int)((Math.random()*100) % 4) + 1;
        int[] ret = new int[4];
        if(direction == 1){
            if(board.tiles[id].getUp()){ //ελεγχος για εμποδιο μπροστα, ο τοιχος των οριων θεωρειται επισης εμποδιο!
                System.out.println("You can't move that way!");
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; // καθως δεν κουνηθηκε, δεν βρηκε καποιο supply, αρα το supply id = 0
            } 
            else{
                this.x = this.x + 1;
                id = id + board.getN();
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0;
                if(board.tiles[id].getSupply()){
                    for(int i=0; i<board.getS(); i++){
                        if(board.supplies[i].getSupplyTileId() == id){
                            ret[3] = board.supplies[i].getSupplyId(); //βρηκε supply αρα κραταει το id του στην 4η θεση του πινακα
                            board.supplies[i].setX(0);
                            board.supplies[i].setY(0);                      //μηδενισμος των συντεταγμενων του supply που βρηκα
                            board.supplies[i].setSupplyTileId(0);
                            break;
                        }
                    }
                    System.out.println("You have found a supply with id: " + ret[3]);
                    setScore(getScore() + 1); //αυξανει το τωρινο σκορ κατα 1 αφου βρηκε supply
                }
            }
        }
        else if(direction == 3){
            if(board.tiles[id].getRight()){ //ελεγχος για εμποδιο δεξια, ο τοιχος των οριων θεωρειται επισης εμποδιο
                System.out.println("You can't move that way!");
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; // καθως δεν κουνηθηκε, δεν βρηκε καποιο supply, αρα το supply id = 0
            } 
            else{
                this.y = this.y + 1;
                id = id + 1;
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; //δεν βρηκε supply
                if(board.tiles[id].getSupply()){
                    for(int i=0; i<board.getS(); i++){
                        if(board.supplies[i].getSupplyTileId() == id){
                            ret[3] = board.supplies[i].getSupplyId(); //βρηκε supply αρα κραταει το id του στην 4η θεση του πινακα
                            board.supplies[i].setX(0);
                            board.supplies[i].setY(0);                      //μηδενισμος των συντεταγμενων του supply που βρηκα
                            board.supplies[i].setSupplyTileId(0);
                            break;
                        }
                    }
                    System.out.println("You have found a supply with id: " + ret[3]);
                    setScore(getScore() + 1); //αυξανει το τωρινο σκορ κατα 1 αφου βρηκε supply
                }
            }
        }
        else if(direction == 5){
            if(board.tiles[id].getDown()){
                System.out.println("You can't move that way!");
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; // καθως δεν κουνηθηκε, δεν βρηκε καποιο supply, αρα το supply id = 0
            } 
            else{
                this.x = this.x - 1;
                id = id - board.getN();
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; //δεν βρηκε supply
                if(board.tiles[id].getSupply()){
                    for(int i=0; i<board.getS(); i++){
                        if(board.supplies[i].getSupplyTileId() == id){
                            ret[3] = board.supplies[i].getSupplyId(); //βρηκε supply αρα κραταει το id του στην 4η θεση του πινακα
                            board.supplies[i].setX(0);
                            board.supplies[i].setY(0);                      //μηδενισμος των συντεταγμενων του supply που βρηκα
                            board.supplies[i].setSupplyTileId(0);
                            break;
                        }
                    }
                    System.out.println("You have found the supply with id: " + ret[3]);
                    setScore(getScore() + 1); //αυξανει το τωρινο σκορ κατα 1 αφου βρηκε supply
                }

            }
        }
        else if(direction == 7){
            if(board.tiles[id].getLeft() || board.tiles[id].getY() == 0){
                System.out.println("You can't move that way!");
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; // καθως δεν κουνηθηκε, δεν βρηκε καποιο supply, αρα το supply id = 0
            } 
            else{
                this.y = this.y - 1;
                id = id - 1;
                ret[0] = id;
                ret[1] = this.x;
                ret[2] = this.y;
                ret[3] = 0; //δεν βρηκε supply
                if(board.tiles[id].getSupply()){
                    for(int i=0; i<board.getS(); i++){
                        if(board.supplies[i].getSupplyTileId() == id){
                            ret[3] = board.supplies[i].getSupplyId(); //βρηκε supply αρα κραταει το id του στην 4η θεση του πινακα
                            board.supplies[i].setX(0);
                            board.supplies[i].setY(0);                      //μηδενισμος των συντεταγμενων του supply που βρηκα
                            board.supplies[i].setSupplyTileId(0);
                            break;
                        }
                    }
                    System.out.println("You have found a supply with id: " + ret[3]);
                    setScore(getScore() + 1); //αυξανει το τωρινο σκορ κατα 1 αφου βρηκε supply
                }
            }

        }
        return ret;
    }

    
}
