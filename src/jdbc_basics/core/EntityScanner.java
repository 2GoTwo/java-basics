package jdbc_basics.core;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import jdbc_basics.domain.Animal;

public class EntityScanner {
	
	private static String pkgName;
	
	public static List<Class<?>> getClassesForPackage() throws IOException, URISyntaxException {
	    final String pkgPath = pkgName.replace('.', '/');
	    final URI pkg = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(pkgPath)).toURI();
	    final ArrayList<Class<?>> allClasses = new ArrayList<Class<?>>();

	    Path root;
	    if (pkg.toString().startsWith("jar:")) {
	        try {
	            root = FileSystems.getFileSystem(pkg).getPath(pkgPath);
	        } catch (final FileSystemNotFoundException e) {
	            root = FileSystems.newFileSystem(pkg, Collections.emptyMap()).getPath(pkgPath);
	        }
	    } else {
	        root = Paths.get(pkg);
	    }

	    final String extension = ".class";
	    try (final Stream<Path> allPaths = Files.walk(root)) {
	        allPaths.filter(Files::isRegularFile).forEach(file -> {
	            try {
	                final String path = file.toString().replace('\\', '.');
	                final String name = path.substring(path.indexOf(pkgName), path.length() - extension.length());
	                allClasses.add(Class.forName(name));
	            } catch (final ClassNotFoundException | StringIndexOutOfBoundsException ignored) {
	            }
	        });
	    }
	    return allClasses;
	}
	
	public static List<Class<?>> getClassesAnnotatedWithEntity() throws IOException, URISyntaxException {
		List<Class<?>> annotatedClass = new ArrayList<Class<?>>();
	    List<Class<?>> allClasses =  getClassesForPackage();
	    for(Class<?> cls : allClasses) {
	    	Annotation[] annotations = cls.getAnnotations();
	    	for(Annotation anno : annotations) {
	    		if(anno instanceof Entity) {
	    			annotatedClass.add(cls);
	    		}
	    	}
	    }
		return annotatedClass;
	}
	
	public static void main(final String[] argv) throws IOException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("helloé");
		EntityScanner.pkgName = "jdbc_basics";
	    for (final Class<?> cls : getClassesAnnotatedWithEntity()) {
	        System.out.println(cls.getName());
	        Class<?> someClass = Class.forName(cls.getName());
	        Object animal;
			try {
				animal = someClass.getDeclaredConstructor().newInstance();
				if(animal instanceof Animal)
		        	System.out.println(animal);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
	        
	    }
	}
}
