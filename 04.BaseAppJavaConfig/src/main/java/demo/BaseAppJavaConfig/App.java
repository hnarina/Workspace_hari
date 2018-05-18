package demo.BaseAppJavaConfig;


import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import demo.services.WalletServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Map<String, Customer> data = new HashMap<String, Customer>();
		//WalletRepoImpl repo = new WalletRepoImpl(data);
		//WalletServiceImpl service = new WalletServiceImpl(repo);
        AnnotationConfigApplicationContext ctx =new AnnotationConfigApplicationContext();
        ctx.scan("demo.");
        ctx.refresh();
        
    	//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("demo/BaseAppJavaConfig/AppConfig.java");
  		WalletServiceImpl service = ctx.getBean("service",WalletServiceImpl.class);
		  
		service.createAccount("Meenal", "9649658180", 9000);
		System.out.println(service.showBalance("9649658180"));
		service.createAccount("harisai ", "7702508656", 1000);
		System.out.println(service.showBalance("7702508656"));
		service.createAccount("ramteja", "1234567890", 6000);
		System.out.println(service.showBalance("1234567890"));
		service.withdrawl("7702508656", 400);
		System.out.println(service.showBalance("7702508656"));
		service.deposit("7702508656", 1400);
		System.out.println(service.showBalance("7702508656"));
		//ctx.refresh();
		
		
    }
}
