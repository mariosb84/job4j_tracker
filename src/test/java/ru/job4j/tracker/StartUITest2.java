package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
//import static sun.jvm.hotspot.runtime.VMOps.Exit;

public class StartUITest2 {

  /*  @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
     //   Item item = tracker.add(new Item());
     //   item.setName("Replaced item");
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
      /*  String replacedName = "New item name";
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0" , replacedName, id/* входные параметры для ReplaceAction *///, "1"}
     /*   );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        //assertThat(tracker.findById(item.getId()), is(replacedName));
        assertThat(tracker.findAll()[0].getName(), is("New item name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
       /* Item item = tracker.add(new Item());
        item.setName("Deleted item");
        String id = String.valueOf(item.getId());
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
     /*   Input in = new StubInput(
                new String[] {"0" ,id/* входные параметры для DeleteAction *///, "1"}
      /*  );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));

    }
    */
  @Test
  public void whenExit() {
      Output out = new StubOutput();
      Input in = new StubInput(
              new String[] {"0"}
      );
      Tracker tracker = new Tracker();
      UserAction[] actions = {
              new ExitAction(out)
      };
      new StartUI(out).init(in, tracker, actions);
      assertThat(out.toString(), is(
              "Menu." + System.lineSeparator() +
                      "0.Exit Program." + System.lineSeparator() +
                      "=== Exit menu ====" + System.lineSeparator()
      ));
  }
    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setName("itemFirst");
        Input in = new StubInput(
                new String[] {"0", "1" }
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0.Show all items." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Show all items ===" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0.Show all items." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Exit menu ====" + System.lineSeparator()
        ));

    }
    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setName("itemFirst");
        String findName = "itemFirst";
        Input in = new StubInput(
                new String[] {"0", findName, "1" }
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0.Find items by name." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Find Item by name ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0.Find items by name." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Exit menu ====" + System.lineSeparator()
        ));

    }
    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item());
        item.setName("itemFirst");
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1" }
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0.Find item by Id." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Find Item by id ====" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0.Find item by Id." + System.lineSeparator() +
                        "1.Exit Program." + System.lineSeparator() +
                        "=== Exit menu ====" + System.lineSeparator()
        ));

    }
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "-1", "0" /* Пункты меню: неверный, верный.*/ }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0.Exit Program.%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0.Exit Program.%n"
                                + "=== Exit menu ====" + System.lineSeparator()
                )
        ));
    }
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }
    @Test
    public void whenValidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "a", "b", "0" }
        );
        ValidateInput input = new ValidateInput(out, in);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0.Exit Program.%n"
                                + "Please enter validate data again."+ System.lineSeparator()
                                + "Please enter validate data again."+ System.lineSeparator()
                                + "=== Exit menu ====" + System.lineSeparator()
                )
        ));
    }
}