namespace ConsoleRPG {
    public class Point {
        private int points {get;set;}
        
        public void OneMorePoint() {
            this.points++;
            Console.WriteLine("One more point - Vous avez : " + this.points + " points");
        }
    }
}