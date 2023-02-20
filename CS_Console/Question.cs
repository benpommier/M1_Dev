namespace ConsoleRPG {
    public class Question {

        private string[] questions {get;set;}
        public int count => this.questions.Length;
        public void generateQuestion()
        {
            this.questions = new string[4];
            this.questions[0] = "Bonjour, comment allez-vous ?";
            this.questions[1] = "Bonjour, comment allez-vous ? Mais 2";
            this.questions[2] = "Bonjour, comment allez-vous ? Mais 3";
            this.questions[3] = "Bonjour, comment allez-vous ? Mais 4";
         }

        public void Print(int i) {
            Console.WriteLine(this.questions[i]);
            Console.WriteLine("Veuillez saisir la bonne réponse :");
        }

    }
}