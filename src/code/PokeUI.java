package code;



public enum PokeUI implements MayoUiLib.Screen {
    TESTING () {
        @Override
        public MayoUiLib.Screen whileActive() throws Exception {
            MayoUiLib.UIUtils.printSpacing();
            System.out.println("Debug Mode:");
            System.out.println("0) Exit");
            System.out.println("1) Pokecardmaker URL to Source");
            System.out.println("2) Pokecardmaker URL to Stats");
            switch (MayoUiLib.UIUtils.getRangeAnswer(0, 2)) {
                case 0: // Exit
                    return PokeUI.MAIN;
                case 1: // URL To Source
                    MayoUiLib.UIUtils.printSpacing();
                    System.out.println("\nInput URL:");
                    //DebugMethods.getSourceFromURL(MayoUiLib.UIUtils.getAnswer());
                    break;
                case 2: // URL To Stats
                    MayoUiLib.UIUtils.printSpacing();
                    System.out.println("\nInput URL:");
                    //System.out.println(Conversion.sourceToCard(Conversion.getURLSource(MayoUiLib.UIUtils.getAnswer())));
                    break;
            }
            return null;
        }
    },

    MAIN () {
        @Override
        public void onEntrance(MayoUiLib.Screen previousScreen) {
            MayoUiLib.UIUtils.printSpacing();
            System.out.println("Welcome to May's Pokemon Card Database Utility System! (PCDUS for short)");
            System.out.println("1) Check Status");
            System.out.println("2) Add a card");
            System.out.println("3) Add a set of cards");
            System.out.println("4) Exit Program");
            System.out.println("\nPlease choose an option...");
        }
        @Override
        public MayoUiLib.Screen whileActive() {
            return MayoUiLib.UIUtils.getAnswer(
                    new String[] {"0", "1", "2", "3", "4", "5"},
                    new PokeUI[] {
                            PokeUI.TESTING,      // 0
                            PokeUI.STATUSROOM,   // 1
                            null,                   // 2
                            null,                   // 3
                            null,                   // 4
                            null                    // 5
                    }
            );
        }
    },

    STATUSROOM () {
        @Override
        public void onEntrance(MayoUiLib.Screen previousScreen) {
            MayoUiLib.UIUtils.printSpacing();
            System.out.println("# of Cards: NONE");
            System.out.println("# of Sets: NONE");
        }
        @Override
        public MayoUiLib.Screen whileActive() {
            System.out.println("\nPress Enter when done...");
            // Doesn't save the answer.  Only used to pause until they hit enter
            MayoUiLib.UIUtils.getAnswer();
            return PokeUI.MAIN;
        }
    }
}
