package Utility;

import com.google.gson.Gson;
import constants.Env;
import pojo.Config;
import pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONUtility {
    public static Environment readJSON(Env env) {
        Gson gson = new Gson();
        File json = new File(System.getProperty("user.dir") + "\\src\\config\\config.json");
        Environment environment;
        try {
            FileReader fileReader = new FileReader(json);
            Config config = gson.fromJson(fileReader, Config.class);
            environment = config.getEnvironments().get("QA");
            System.out.println(environment.getUrl());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return environment;

    }
}
