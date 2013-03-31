package nu.danielsundberg.yakutia;

import nu.danielsundberg.yakutia.exceptions.PlayerAlreadyExists;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@AuthorizeInstantiation("USER")
public class ApiPage extends NavbarPage {


    private String name = "myname";

    public ApiPage(PageParameters parameters) throws NamingException {
        super(parameters);


        Form form = new Form("form");

        PropertyModel model = new PropertyModel<String>(this, "name");
        TextField<String> text = new TextField<String>("name", model);
        add(new Label("msg", model));
        Button button = new Button("user") {

            @Override
            public void onSubmit() {
                //setName("FIX ME");
                InitialContext ctx = null;
                PreGameInterface test=null;

                try {
                    ctx = new InitialContext();
                    test = (PreGameInterface) ctx.lookup("preGameBean");
                    test.createNewPlayer(name, "fuckface");
                } catch (NamingException e) {

                } catch (PlayerAlreadyExists pae) {

                }

            }
        };

        form.add(button);
        form.add(text);
        add(form);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
