package bg.hotel.scoperesolver;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.web.context.WebApplicationContext;

public class CdiScopeMetadataResolver extends AnnotationScopeMetadataResolver {

	/**
	 * Checks if one of the following CDI scope annoations are used and maps
	 * them to their matching Spring scopes:
	 * 
	 * <ul>
	 * <li><code>&#064;javax.enterprise.context.RequestScoped</code></li>
	 * <li><code>&#064;javax.enterprise.context.SessionScoped</code></li>
	 * <li><code>&#064;javax.enterprise.context.ApplicationScoped</code></li>
	 * </ul>
	 * 
	 * If none of them are found it delegates back to the original Spring
	 * <code>AnnotationScopeMetadataResolver</code> class.
	 */
	@Override
	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
		ScopeMetadata metadata = new ScopeMetadata();
		if (definition instanceof AnnotatedBeanDefinition) {
			AnnotatedBeanDefinition annDef = (AnnotatedBeanDefinition) definition;
			Set<String> annotationTypes = annDef.getMetadata()
					.getAnnotationTypes();

			if (annotationTypes.contains(RequestScoped.class.getName())) {
				metadata.setScopeName(WebApplicationContext.SCOPE_REQUEST);
			} else if (annotationTypes.contains(SessionScoped.class.getName())) {
				metadata.setScopeName(WebApplicationContext.SCOPE_SESSION);
			} else if (annotationTypes.contains(ApplicationScoped.class
					.getName())) {
				metadata.setScopeName(WebApplicationContext.SCOPE_APPLICATION);
			} else {
				// do the regular Spring stuff..
				return super.resolveScopeMetadata(definition);
			}
		}
		return metadata;
	}
}