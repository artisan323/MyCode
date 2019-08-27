package make_server;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlTest02 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //SAX解析
        //1、获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2、从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3、编写文档
        //4、加载文档Document注册器
        PersonHandler handler = new PersonHandler();
        //5、解析
        parse.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("make_server/p.xml"),handler);

        //获取数据
        List<Person> persons = handler.getPersons();
        for (Person p : persons){
            System.out.println(p.getName() + "-->" + p.getAge());
        }
    }
}
class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (tag != null){
            if (tag.equals("name")){
                person.setName(contents);
                System.out.println(" --"+contents);
            }else if (tag.equals("age")){
                person.setAge(Integer.valueOf(contents));
                System.out.println(" --"+Integer.valueOf(contents));
            }
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");

            if (qName != null){
                tag = qName;
                System.out.println("--" + tag + "--");
                if (tag.equals("person")){
                    person = new Person();
                }
            }

        System.out.println("startElement:" + tag);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
        if (qName != null){
            if (qName.equals("person")){
                persons.add(person);
            }
            tag = null;
        }
    }

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    public List<Person> getPersons() {
        return persons;
    }

}
