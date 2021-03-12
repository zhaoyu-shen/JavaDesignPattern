package com.szy.designpattern.abstractfactory;

/*
* 抽象工厂设计模式
* @author：沈钊宇
* 定义一组接口，当使用的数据库不同时，只需实现不同的接口实现类
* */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils=new OracleDatabaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommand command = iDatabaseUtils.getCommand();
        command.command();

    }
}



class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connected.");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command.");
    }
}

class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connect.");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command.");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}

interface IConnection{
    void connect();
}

interface ICommand{
    void command();
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

