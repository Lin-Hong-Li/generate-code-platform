package com.lhl.cli;

import com.lhl.cli.command.ConfigCommand;
import com.lhl.cli.command.GenerateCommand;
import com.lhl.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "lhl", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体命令，或输入--help查看命令提示");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
