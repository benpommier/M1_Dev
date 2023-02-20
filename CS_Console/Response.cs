namespace ConsoleRPG {
    public class Response {

        private string[] responses {get;set;}
        public void GoodResponse()
        {
            this.responses = new string[4];
            this.responses[0] = "Bien";
            this.responses[1] = "Pas bien";
            this.responses[2] = "10";
            this.responses[3] = "Non";
        }

        public Boolean VerifyResponse(int i) {
            string input = Console.ReadLine();
            if (input == responses[i]) {
                Console.WriteLine("Félicitations!");
                return true;
            }
            else {
                Console.WriteLine("Vous ne réussirez rien dans la vie.");
                return false;
            }
        }
    }
}