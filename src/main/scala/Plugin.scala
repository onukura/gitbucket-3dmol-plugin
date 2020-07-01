import javax.servlet.ServletContext
import gitbucket.core.plugin.{PluginRegistry}
import gitbucket.core.service.SystemSettingsService
import gitbucket.core.service.SystemSettingsService.SystemSettings
import io.github.gitbucket.solidbase.model.Version

import scala.util.Try

class Plugin extends gitbucket.core.plugin.Plugin {
  override val pluginId: String = "3DMol"
  override val pluginName: String = "Molecular renderer Plugin"
  override val description: String = "Rendering molecular files."
  override val versions: List[Version] = List(
    new Version("0.1.0"),
  )

  private[this] var renderer: Option[MolRenderer] = None

  override def initialize(registry: PluginRegistry, context: ServletContext, settings: SystemSettingsService.SystemSettings): Unit = {
    val test = Try{ new MolRenderer() }
    val mol = test.get
    registry.addRenderer("pdb", mol)
    renderer = Option(mol)
    super.initialize(registry, context, settings)
  }

  override def shutdown(registry: PluginRegistry, context: ServletContext, settings: SystemSettings): Unit = {
    renderer.map(r => r.shutdown())
  }

}