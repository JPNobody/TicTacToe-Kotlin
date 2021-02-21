
/*This is the class where you can create Tic Tac Toe boards.
  It is important that it is a class in that I make this into Ultimate Tic Tac Toe */
open class TicTacToeBoard() {
    //set all the variables

    // This is an mutable list of mutable lists that contains numbers to be displayed
    // easily for the user to pick the spot on the array. The numbers
    // are strings so that they can be changed to 'x' or 'o'
    protected val boardValues = mutableListOf(mutableListOf("1", "2", "3"),
        mutableListOf("4", "5", "6"),
        mutableListOf("7", "8", "9"))

    // This records if the game is won or not
    private var _won: Boolean = false

    // This records who won
    var whoWon: String = "No one"

    // This counts how many rounds have been played
    protected var countRounds: Int = 0

    // This remembers whose turn it is.
    protected var whoseTurn: String = "x"

    //This is an mutable list that is used for printing out the board.
    val printBoard: MutableList<String> = mutableListOf(
        "${boardValues[0][0]}|${boardValues[0][1]}|${boardValues[0][2]}",
        "-|-|-",
        "${boardValues[1][0]}|${boardValues[1][1]}|${boardValues[1][2]}",
        "-|-|-",
        "${boardValues[2][0]}|${boardValues[2][1]}|${boardValues[2][2]}")

    // This is to allow other parts of the code to see if the game is
    // won without being able to change if the game is won.
    val won: Boolean get() = _won

    //This function resets the board to untouched
    fun resetBoard(){
        var numb = 1
        for (i in 0..2)
            for (j in 0..2)
            {
                boardValues[i][j] = numb.toString()
                ++numb
            }
        setPrintBoard()

    }

    // This sets the mutable list that contains the lines for printing the board to the
    // actual board values
    fun setPrintBoard(){
        printBoard[0] = "${boardValues[0][0]}|${boardValues[0][1]}|${boardValues[0][2]}"
        printBoard[1] = "-|-|-"
        printBoard[2] = "${boardValues[1][0]}|${boardValues[1][1]}|${boardValues[1][2]}"
        printBoard[3] = "-|-|-"
        printBoard[4] = "${boardValues[2][0]}|${boardValues[2][1]}|${boardValues[2][2]}"
    }

    // This function records that someone won the game.
    private fun someoneWon(personWhoWon: String): Boolean {
        if (_won) {
//            println("ERROR! Game is already won")
            return true
        }
        else {
            _won = true
            whoWon = personWhoWon
            return _won
        }
    }

    // This function takes in a location on the board, and sets that location
    // to the player whose turn it is, and then returns if it was able to
    // set the value or not.
    fun setValue(loca: String): Boolean {
        when (loca) {
            "1" -> if (boardValues[0][0] == "x" || boardValues[0][0] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }

            else {
                boardValues[0][0] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "2" -> if (boardValues[0][1] == "x" || boardValues[0][1] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[0][1] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "3" -> if (boardValues[0][2] == "x" || boardValues[0][2] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[0][2] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "4" -> if (boardValues[1][0] == "x" || boardValues[1][0] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[1][0] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "5" -> if (boardValues[1][1] == "x" || boardValues[1][1] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[1][1] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "6" -> if (boardValues[1][2] == "x" || boardValues[1][2] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[1][2] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "7" -> if (boardValues[2][0] == "x" || boardValues[2][0] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[2][0] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "8" -> if (boardValues[2][1] == "x" || boardValues[2][1] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[2][1] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            "9" -> if (boardValues[2][2] == "x" || boardValues[2][2] == "o")
            {
                println("ERROR You can't go there!")
                return false
            }
            else {
                boardValues[2][2] = whoseTurn
                setPrintBoard()
                ++countRounds
                return true
            }
            else -> {
                println("ERROR You can't go there!")
                return false
            }
        }
        return false
    }

    /* This function checks if someone has won the TicTacToe board */
    // Future TODO Simplify the checking into it's own function.
    // This function takes in a round count, so that it only starts to
    // check if someone has won, when someone could have won.
    fun checkWin(checkRoundCount: Boolean): Boolean {
        if (checkRoundCount)
        {
            return false
        }
        else {
            // Check horizontal wins
            if (boardValues[0][0] == boardValues[0][1] && boardValues[0][1] == boardValues[0][2]) {
                return someoneWon(boardValues[0][0])
            } else if (boardValues[1][0] == boardValues[1][1] && boardValues[1][1] == boardValues[1][2]) {
                return someoneWon(boardValues[1][0])
            } else if (boardValues[2][0] == boardValues[2][1] && boardValues[2][1] == boardValues[2][2]) {
                return someoneWon(boardValues[2][0])
            }

            // Check vertical wins
            if (boardValues[0][0] == boardValues[1][0] && boardValues[1][0] == boardValues[2][0]) {
                return someoneWon(boardValues[0][0])
            } else if (boardValues[0][1] == boardValues[1][1] && boardValues[1][1] == boardValues[2][1]) {
                return someoneWon(boardValues[0][1])
            } else if (boardValues[0][2] == boardValues[1][2] && boardValues[1][2] == boardValues[2][2]) {
                return someoneWon(boardValues[0][1])
            }

            // Check diagonal wins
            if (boardValues[0][0] == boardValues[1][1] && boardValues[1][1] == boardValues[2][2]) {
                return someoneWon(boardValues[0][0])
            } else if (boardValues[0][2] == boardValues[1][1] && boardValues[1][1] == boardValues[2][0]) {
                return someoneWon(boardValues[0][2])
            }
        }
        return false
    }

    // This function returns true when there are no more unmarked spaces on a
    // board, but the game isn't won, and is therefore a tie.
    fun checkTie(maxRounds: Int): Boolean{
        return countRounds >= maxRounds
    }

    // This function switches whose turn it is
    fun switchTurn(){
        when (whoseTurn) {
            "x" -> whoseTurn = "o"
            "o" -> whoseTurn = "x"
            else -> println("ERROR, resetting game")
        }
    }

    // This function displays the tic tac toe board.
    open fun displayBoard(){
        for (i in printBoard) {
            println(i)
        }

    }


    // This is the only public function, and this function allows you to play tic tac toe.
    open fun play(){
        do {
            displayBoard()
            val instructions = "It's $whoseTurn's turn. \nInput the number of where you would like to go."
            println(instructions)
            var decision = readLine().toString()
            if (setValue(decision))
                switchTurn()
        } while (!checkWin(countRounds < 5) && !checkTie(9))
        displayBoard()
        if (checkTie(9))
            whoWon = "no one"
        println("$whoWon wins!")
    }
}



/******************************************************************************************************************
 * Class separation
 *****************************************************************************************************************/




//This is the class for the Ultimate Tic Tac Toe Board.
class UltimateTicTacToeBoard(): TicTacToeBoard() {
    // set the variables

    // This is for identifying what square the player has to go in
    private var square: String = "any"

    //This is an mutable list of mutable lists of each tic tac toe board.
    private val biggerBoardValues: MutableList<MutableList<TicTacToeBoard>> =
        mutableListOf(
            mutableListOf(TicTacToeBoard(), TicTacToeBoard(), TicTacToeBoard()),
            mutableListOf(TicTacToeBoard(), TicTacToeBoard(), TicTacToeBoard()),
            mutableListOf(TicTacToeBoard(), TicTacToeBoard(), TicTacToeBoard()))

    // This sets the printBoard mutable list for a tic tac toe board to a giant x
    private fun setBoardXWon(board: TicTacToeBoard) {
        board.printBoard[0] = "\\   /"
        board.printBoard[1] = " \\ / "
        board.printBoard[2] = "  \\  "
        board.printBoard[3] = " / \\ "
        board.printBoard[4] = "/   \\"
    }
    // This sets the printBoard mutable list for a tic tac toe board to a giant o
    private fun setBoardOWon(board: TicTacToeBoard) {
        board.printBoard[0] = " ___"
        board.printBoard[1] = "|   |"
        board.printBoard[2] = "|   |"
        board.printBoard[3] = "|   |"
        board.printBoard[4] = " --- "
    }

    // This function takes in a number and returns the associated square on
    // the big tic tac toe board.
    private fun interpretSquare(): TicTacToeBoard{
        when (square) {
            "1" -> return biggerBoardValues[0][0]
            "2" -> return biggerBoardValues[0][1]
            "3" -> return biggerBoardValues[0][2]
            "4" -> return biggerBoardValues[1][0]
            "5" -> return biggerBoardValues[1][1]
            "6" -> return biggerBoardValues[1][2]
            "7" -> return biggerBoardValues[2][0]
            "8" -> return biggerBoardValues[2][1]
            "9" -> return biggerBoardValues[2][2]
            else -> println("Square Cannot be interpreted")
        }
        // just return something. The error will be printed out.
        return TicTacToeBoard()
    }

    /* applies a method to all the boards in the ultimate board */
    private fun applyToAll(c: String){
        for (i in biggerBoardValues)
        {
            for (j in i) {
                // add more possible strings in the future.
                when (c){
                    "checkTie" -> if (j.checkTie(9)) {
                        //reset the board.
                        j.resetBoard()
                    }
                    "checkWin" -> j.checkWin(countRounds < 5)
                    "switchTurn" -> j.switchTurn()
                }
                //If the board is won, set the overallBoard value to won.
                if (j.won && super.boardValues[biggerBoardValues.indexOf(i)][i.indexOf(j)] != j.whoWon){
                    super.boardValues[biggerBoardValues.indexOf(i)][i.indexOf(j)] = j.whoWon
                    when(j.whoWon){
                        "x" -> setBoardXWon(j)
                        "o" -> setBoardOWon(j)
                    }
                }

            }
        }
    }

    //This functions displays the Ultimate Tic Tac Toe board.
    override fun displayBoard() {
        //print out every row of boards
        for (i in 0..2){
            println("${super.boardValues[i][0]}      |${super.boardValues[i][1]}      |${super.boardValues[i][2]}      ")
            //for each row, print out the lines of the board
            for (k in 0..4){
                //for each column in the row, print out the board.
                for (j in 0..2){
                    print(" ")
                    print(biggerBoardValues[i][j].printBoard[k])
                    print(" ")
                    if (j != 2)
                        print("|")
                    else
                        print("\n")
                }
            }
            if (i != 2)
                println("-------|-------|-------")
        }
    }

    // This function checks a single board if it is won.
    private fun checkIndivBoardWon(boardNumber: String): Boolean{
        when(boardNumber){
            "1" -> return biggerBoardValues[0][0].won
            "2" -> return biggerBoardValues[0][1].won
            "3" -> return biggerBoardValues[0][2].won
            "4" -> return biggerBoardValues[1][0].won
            "5" -> return biggerBoardValues[1][1].won
            "6" -> return biggerBoardValues[1][2].won
            "7" -> return biggerBoardValues[2][0].won
            "8" -> return biggerBoardValues[2][1].won
            "9" -> return biggerBoardValues[2][2].won
        }
        return false
    }

    //This function runs the game.
    override fun play() {
        do {
            // If the play can go anywhere...
            if (square == "any") {
                // Have the user pick which quadrant to play on.
                displayBoard()
                val instructions1 = "It's ${super.whoseTurn}'s turn. \nInput the number of the quadrant you would like go on."
                println(instructions1)
                var choice = readLine().toString()
                when (choice){
                    "1","2","3","4","5","6","7","8","9" -> square = choice
                    else -> if (true)
                    {
                        println("ERROR! That is not a valid quadrant!")
                        square ="any"
                    }
                }
            }
            // If the player has to go on a specific board.
            else {
                //Check if that board is won, if so, assign square to any.
                if (checkIndivBoardWon(square))
                    square = "any"
                else
                {
                    displayBoard()
                    var currBoard = interpretSquare()
                    val instructions2 = "It's ${super.whoseTurn}'s turn. \nYou are in quadrant $square.\nWhere would you like to go?"
                    println(instructions2)
                    var c = readLine().toString()
                    if (currBoard.setValue(c)){
                        square = c
                        ++countRounds
                        applyToAll("switchTurn")
                        switchTurn()
                    }

                }

            }
            //check if any board is won or tied.
            applyToAll("checkWin")
            applyToAll("checkTie")
        } while (!checkWin(countRounds < 17))
        displayBoard()
        println("$whoWon won!")
    }
}


/******************************************************************************************************************
 * Class separation from main func
 *****************************************************************************************************************/

// This is the main function and it creates a board and
// calls the play function on the board
fun main(args: Array<String>) {
//    val board1 = TicTacToeBoard()
    val board1 = UltimateTicTacToeBoard()
    board1.play()
}
