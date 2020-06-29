import gitbucket.core.controller.Context
import gitbucket.core.plugin.{RenderRequest, Renderer}
import play.twirl.api.Html

class MolRenderer extends Renderer {

  def render(request: RenderRequest): Html = {
    import request._
    Html(toHtml(fileContent)(context))
  }

  def toHtml(fileContent: String)(implicit context: Context): String = {

    val renerMaterial =
      s"""
         |<div id="container-01" style="width: 100%; height: 600px; position: relative;"></div>
         |<div id=content hidden>$fileContent</div>
         |""".stripMargin

    val renderFunction =
      """
         |<script src="https://cdnjs.cloudflare.com/ajax/libs/3Dmol/1.4.0/3Dmol-min.js"></script>
         |<script>
         |  $(function () {
         |    let element = $("#container-01");
         |    let config = { backgroundColor: 'white' };
         |    let viewer = $3Dmol.createViewer( element, config );
         |    let pdb = $("#content").val();
         |    jQuery.ajax( pdb, {
         |      success: function(data) {
         |        let v = viewer;
         |        v.addModel( data, "pdb" );                       /* load data */
         |        v.setStyle({}, {cartoon: {color: 'spectrum'}});  /* style all atoms */
         |        v.zoomTo();                                      /* set camera */
         |        v.render();                                      /* render scene */
         |      },
         |      error: function(hdr, status, err) {
         |        console.error( "Failed to load PDB " + pdbUri + ": " + err );
         |      },
         |    });
         |  });
         |</script>
         |""".stripMargin

    s"""
       |$renerMaterial
       |$renderFunction
       |""".stripMargin

  }

  def shutdown(): Unit = {
  }

}
