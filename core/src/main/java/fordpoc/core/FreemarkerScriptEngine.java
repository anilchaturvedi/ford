package fordpoc.core;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.api.AbstractSlingScriptEngine;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerScriptEngine extends AbstractSlingScriptEngine {
	private static final Configuration CONFIG = new Configuration(null);

    public FreemarkerScriptEngine(ScriptEngineFactory factory) {
        super(factory);
    }
    @Override
    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        Bindings bindings = scriptContext.getBindings(ScriptContext.ENGINE_SCOPE);
        SlingScriptHelper helper = (SlingScriptHelper) bindings.get(SlingBindings.SLING);
        String scriptName = helper.getScript().getScriptResource().getPath();
        try {
            Template tmpl = new Template(scriptName, reader, CONFIG);
            tmpl.process(bindings, scriptContext.getWriter());
        } catch (Exception e) {
            throw new ScriptException(e);
        }
        return null;
    }

	
}
