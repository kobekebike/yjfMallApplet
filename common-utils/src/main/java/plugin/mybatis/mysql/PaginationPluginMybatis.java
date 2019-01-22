package plugin.mybatis.mysql;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

public class PaginationPluginMybatis extends PluginAdapter{
	
	/** 
	 * <pre> 
	 * add pagination using mysql limit. 
	 * This class is only used in ibator code generator. 
	 * </pre> 
	 */   
	    @Override  
	    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,  
	            IntrospectedTable introspectedTable) {  
	        // add field, getter, setter for limit clause  
	        addLimit(topLevelClass, introspectedTable, "limitStart");  
	        addLimit(topLevelClass, introspectedTable, "limitEnd");  
	        return super.modelExampleClassGenerated(topLevelClass,  
	                introspectedTable);  
	    }  
	    @Override  
	    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(  
	            XmlElement element, IntrospectedTable introspectedTable) {  
	        XmlElement isParameterPresenteElemen = (XmlElement) element  
	                .getElements().get(element.getElements().size() - 1);  
	        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$  
	        isNotNullElement.addAttribute(new Attribute("test", " limitEnd > 0")); //$NON-NLS-1$ //$NON-NLS-2$  	          
	        isNotNullElement.addElement(new TextElement(  
	               "limit #{limitStart} , #{limitEnd}"));  
	        isParameterPresenteElemen.addElement(isNotNullElement);  
	        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,  
	                introspectedTable);  
	    }  
	    private void addLimit(TopLevelClass topLevelClass,  
	            IntrospectedTable introspectedTable, String name) {  
	        CommentGenerator commentGenerator = context.getCommentGenerator();  
	        Field field = new Field();  
	        field.setVisibility(JavaVisibility.PROTECTED);  
	        field.setType(FullyQualifiedJavaType.getIntInstance());  
	        field.setName(name);  
	       field.setInitializationString("-1");  
	        commentGenerator.addFieldComment(field, introspectedTable);  
	        topLevelClass.addField(field);  
	        char c = name.charAt(0);  
	        String camel = Character.toUpperCase(c) + name.substring(1);  
	        Method method = new Method();  
	        method.setVisibility(JavaVisibility.PUBLIC);  
	        method.setName("set" + camel);  
	        method.addParameter(new Parameter(FullyQualifiedJavaType  
	                .getIntInstance(), name));  
	        method.addBodyLine("this." + name + "=" + name + ";");  
	        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
	        topLevelClass.addMethod(method);  
	        method = new Method();  
	        method.setVisibility(JavaVisibility.PUBLIC);  
	        method.setReturnType(FullyQualifiedJavaType.getIntInstance());  
	        method.setName("get" + camel);  
	        method.addBodyLine("return " + name + ";");  
	        commentGenerator.addGeneralMethodComment(method, introspectedTable);  
	        topLevelClass.addMethod(method);  
	    }  
	    
	    
	    /**
	     * 增加了insert语句中，自动生成主键的useGeneratedKeys="true" keyProperty=属性
	     * @author hanst
	     * 
	     */
	    public boolean sqlMapInsertElementGenerated(XmlElement element,IntrospectedTable introspectedTable){	    		    	
	    	element.addAttribute(new Attribute("useGeneratedKeys","true"));
	    	List<IntrospectedColumn> col = introspectedTable.getPrimaryKeyColumns();
	    	if (col.size() == 1) 	    	
	    		element.addAttribute(new Attribute("keyProperty",col.get(0).getJavaProperty("")));
	    	return super.sqlMapInsertElementGenerated(element, introspectedTable);	    	
	    }
	    
	    /**
	     * 增加了InsertSelective语句中，自动生成主键的useGeneratedKeys="true" keyProperty=属性
	     * @author hanst
	     */
	    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,IntrospectedTable introspectedTable){	    		    	
	    	element.addAttribute(new Attribute("useGeneratedKeys","true"));
	    	List<IntrospectedColumn> col = introspectedTable.getPrimaryKeyColumns();	    	 
	    	if (col.size() == 1)	    	 	    		 
	    		element.addAttribute(new Attribute("keyProperty",col.get(0).getJavaProperty("")));		    	 
	    	return super.sqlMapInsertSelectiveElementGenerated(element, introspectedTable);	    		    		 
	    }
	    
	    
	    
	    /** 
	     * This plugin is always valid - no properties are required 
	     */  
	    public boolean validate(List<String> warnings) {  
	        return true;  
	    }  
	    public static void generate() {  
	        String config = PaginationPluginMybatis.class.getClassLoader().getResource(  
	                "mybatisConfig.xml").getFile();  
	        String[] arg = { "-configfile", config, "-overwrite" };  
	        ShellRunner.main(arg);  
	    }  
	    public static void main(String[] args) {  
	        generate();  
	    }  
	}  


