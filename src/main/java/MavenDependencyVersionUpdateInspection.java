import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.highlighting.DomElementAnnotationHolder;
import com.intellij.util.xml.highlighting.DomElementsInspection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.dom.DependencyConflictId;
import org.jetbrains.idea.maven.dom.generate.GenerateManagedDependencyAction;
import org.jetbrains.idea.maven.dom.model.MavenDomDependency;
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel;

import java.util.Map;

public class MavenDependencyVersionUpdateInspection extends DomElementsInspection<MavenDomProjectModel> {

    public MavenDependencyVersionUpdateInspection(Class<? extends MavenDomProjectModel> domClass, Class<? extends MavenDomProjectModel> @NotNull ... additionalClasses) {
        super(domClass, additionalClasses);
     }

    @Override
    public void checkFileElement(DomFileElement<MavenDomProjectModel> domFileElement, DomElementAnnotationHolder holder) {
        Map<DependencyConflictId, MavenDomDependency> dependencyMap =
                GenerateManagedDependencyAction.collectManagingDependencies(domFileElement.getRootElement());
        String message = MavenVersionInspectionBundle.message("MavenVersionInspection.has.version.update");
        super.checkFileElement(domFileElement, holder);
    }
}
