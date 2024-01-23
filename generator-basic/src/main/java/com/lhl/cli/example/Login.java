package com.lhl.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;
// some exports omitted for the sake of brevity

@Command(name = "login", version = "login 1.0", mixinStandardHelpOptions = true)
public class Login implements Callable<Integer> {

    @Option(names = { "-u", "--username" }, description = "username", interactive = true, prompt = "请输入用户名：")
    String username;

    @Option(names = { "-p"}, description = "password", arity = "0..1", interactive = true, prompt = "请输入密码：")
    String password;

    @Option(names = { "-cp"}, description = "checkPassword", arity = "0..1", interactive = true, prompt = "请确认密码：")
    String checkPassword;

    @Override
    public Integer call() {
        System.out.println("username = " + this.username);
        System.out.println("password = " + this.password);
        System.out.println("checkPassword = " + this.checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Login()).execute("-u", "-p", "123", "-cp", "123");
        System.exit(exitCode);
    }
}