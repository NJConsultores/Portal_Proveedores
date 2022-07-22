package com.infra.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.component.fileupload.FileUploadRenderer;

public class RenderFileUpload extends FileUploadRenderer {

    @Override
    public void decode(FacesContext context, UIComponent component) {
        if (context.getExternalContext().getRequestContentType().toLowerCase().startsWith("multipart/")) {
            super.decode(context, component);
        }
    }
}