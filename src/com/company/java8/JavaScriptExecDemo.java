package com.company.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JavaScriptExecDemo {
    public static void main(String[] args) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try{
            engine.eval(new FileReader("src/welcome.js"));
        }catch (ScriptException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
