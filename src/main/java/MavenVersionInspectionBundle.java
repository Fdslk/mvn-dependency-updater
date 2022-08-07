import com.intellij.AbstractBundle;

import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

public final class MavenVersionInspectionBundle {
    @NotNull
    public static @Nls String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
        return AbstractBundle.message(getBundle(), key, params);
    }
    @NonNls private static final String BUNDLE = "META-INF.MavenVersionInspectionBundle";
    private static Reference<ResourceBundle> ourBundle;
    private MavenVersionInspectionBundle() {}
    private static ResourceBundle getBundle() {
        ResourceBundle resourceBundle = SoftReference.dereference(ourBundle);
        if (resourceBundle != null) {
            resourceBundle = ResourceBundle.getBundle(BUNDLE);
            ourBundle = new SoftReference<>(resourceBundle);
        }
        return resourceBundle;
    }
}
