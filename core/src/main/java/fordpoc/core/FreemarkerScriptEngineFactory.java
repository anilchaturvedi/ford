package fordpoc.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.scripting.api.AbstractScriptEngineFactory;
@Component
@Service({ScriptEngineFactory.class})
public class FreemarkerScriptEngineFactory extends AbstractScriptEngineFactory {

	 public FreemarkerScriptEngineFactory() {
	        setExtensions("ftl");
	        setMimeTypes("text/x-freemarker");
	        setNames("freemarker");
	    }
	
	 @Override
	 public ScriptEngine getScriptEngine() {
	     return new FreemarkerScriptEngine(this);
	 }

	 @Override
	 public String getLanguageName() {
	     return "Freemarker";
	 }

	 @Override
	 public String getLanguageVersion() {
	     return "2.3.23";
	 }

}
