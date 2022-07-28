package by.ivanchenko.carrental.controller;

import by.ivanchenko.carrental.controller.command.Command;
import by.ivanchenko.carrental.controller.command.CommandName;
import by.ivanchenko.carrental.controller.command.impl.*;

import java.util.HashMap;

final class CommandProvider {

   private static final HashMap<CommandName, Command> commands = new HashMap<>();
        CommandProvider() {
            commands.put(CommandName.REGISTRATION, new RegistrationCommand());
            commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
            commands.put(CommandName.GET_CAR_LIST, new GetCarListCommand());
            commands.put(CommandName.GET_CAR_LIST_FILTRED, new GetCarListFiltredCommand());
            commands.put(CommandName.CHANGE_LANG, new ChangeLangCommand());
            commands.put(CommandName.EDIT_USER, new EditUser());
            commands.put(CommandName.DELETE_USER, new DeleteUser());
            commands.put(CommandName.LOG_OUT, new LogOut());
            commands.put(CommandName.BOOK_CAR, new BookCar());
            commands.put(CommandName.CREATE_ORDER, new CreateOrder());
            commands.put(CommandName.ORDER_INFO, new GetOrderInfo());
            commands.put(CommandName.APPROVE_ORDER, new ApproveOrder());
            commands.put(CommandName.PAY, new PayForOrder());
            commands.put(CommandName.MANAGER_ORDER, new ManagerOrder());
            commands.put(CommandName.DELETE_ORDER, new DeleteOrder());
            commands.put(CommandName.GIVE_CAR_CUSTOMER, new GiveCarCustomer());
            commands.put(CommandName.REGISTER_RETURN, new RegisterReturn());
            commands.put(CommandName.CANCEL_ORDER_MANAGER, new CancelOrderManager());
            commands.put(CommandName.ADD_CAR, new AddCar());
            commands.put(CommandName.CAR_INFO, new CarInfo());
            commands.put(CommandName.DELETE_USER_BY_ADMIN, new DeleteUserByAdmin());
            commands.put(CommandName.DELETE_CAR, new DeleteCar());
            commands.put(CommandName.ALL_USER_INFO, new AllUserInfo());
            // another UNKNOWN

        }

        public static Command getCommand(String name) {
            Command command = null;
            CommandName commandName = null;

            try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
            } catch (IllegalArgumentException | NullPointerException e) {
                //log
                command = commands.get(CommandName.UNKNOWN);
            }
            return command;
        }
}
