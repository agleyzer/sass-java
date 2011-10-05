package com.sass_lang;

import org.jruby.embed.ScriptingContainer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import static org.jruby.embed.LocalVariableBehavior.PERSISTENT;

/**
 * Here goes nothing.
 *
 * @author agleyzer
 */
public class Compiler {
    private void run() {
        ScriptingContainer container = new ScriptingContainer(PERSISTENT);
        container.put("input", resource("input.sass"));
        container.runScriptlet(resource("sass.rb"));
        System.out.println(container.get("output"));
    }

    private String resource(String name) {
        try {
            return IOUtils.toString(getClass().getResourceAsStream(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Compiler().run();
    }
}
