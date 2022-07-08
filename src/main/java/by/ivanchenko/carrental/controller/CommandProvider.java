package by.ivanchenko.carrental.controller;

import java.util.HashMap;

final class CommandProvider {

   private static final HashMap<CommandName, Command> commands = new HashMap<>();
        CommandProvider() {
            commands.put(CommandName.REGISTRATION, new RegistrationCommand());
            commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
            // another

        }

        public static Command getCommand(String name) {
            Command command = null;
            CommandName commandName = null;

            try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
            } catch (IllegalArgumentException | NullPointerException e) {
                //log
                command = commands.get(CommandName.WRONG_COMMAND);
            }
            return command;
        }
}
