using System;

namespace ConsoleRPG {

    public class Game {
        public void Run() {
            // Game logic
                // Ask a question.
                // Receive a response.
                // Tell if true or pas bon
                
                var question = new Question();
                var response = new Response();
                var point = new Point();

                question.generateQuestion();
                response.GoodResponse();

                for (var i = 0; i < question.count; i++) {
                    question.Print(i);
                    if (response.VerifyResponse(i)) {
                        point.OneMorePoint();
                    }
                    // Changer le retun du truc précédent 
                }
        }
    }


    class Program {
        public static void Main(string[] args) {
            // Create my game
            // Launch the game
            var game = new Game();
            game.Run();
        }
    }
}
