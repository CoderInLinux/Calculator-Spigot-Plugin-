package com.coderinlinux.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Calculator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command can only be executed by a player");
            return true;
        }
        if (args.length < 3) {
            commandSender.sendMessage(ChatColor.RED + "Usage: /calc <number1> <operation> <number2>");
            return true;
        }

        Player player = (Player) commandSender;
        try {
            double number1 = Double.parseDouble(args[0]);
            String operation = args[1];
            double number2 = Double.parseDouble(args[2]);

            double result = calculate(number1, operation, number2);
            player.sendMessage(ChatColor.GOLD + "Calculator");
            player.sendMessage(ChatColor.GRAY + "Choose one Operaction: \n" +
                    ChatColor.GREEN + "1.Addition \n" +
                    ChatColor.GREEN + "2.Subtraction \n" +
                    ChatColor.GREEN + "3.Multiplication \n" +
                    ChatColor.GREEN + "4.Division");
            player.sendMessage(ChatColor.GREEN + "The result is: " + ChatColor.AQUA + result);
        } catch (NumberFormatException e) {
            player.sendMessage(ChatColor.RED + "Please enter a valid numbers");
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Error: " + e.getMessage());
        }
        return true;
    }

    private double calculate(double number1, String operation, double number2) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new IllegalArgumentException("Cannot be divided by 2");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
