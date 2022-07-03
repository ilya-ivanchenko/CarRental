package by.ivanchenko.carrental.controller;

import java.util.HashMap;

public class CommandProvider {

    private CommandProvider() {
    }

   private static final HashMap<CommandName, Command> commands = new HashMap<>();
        static {
            commands.put(CommandName.REGISTRATION, new RegistrationCommand());
            // another

        }

        public static Command getCommand(String name) {
            return commands.get(name);  //check
        }


}
