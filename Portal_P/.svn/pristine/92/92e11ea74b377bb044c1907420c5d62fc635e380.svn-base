package com.infra.factura.business.cfd.schema;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.impl.AttributeUseImpl;
import com.sun.xml.xsom.parser.AnnotationContext;
import com.sun.xml.xsom.parser.AnnotationParser;
import com.sun.xml.xsom.parser.AnnotationParserFactory;
import com.sun.xml.xsom.parser.XSOMParser;

public class SchemaReader {
	public static void main(String[] args) throws SAXException, IOException {
		XSOMParser parser = new XSOMParser();
		parser.setAnnotationParser(new AnnotationParserFactory() {
			public AnnotationParser create() {
				return new AnnotationParser() {
					final StringBuffer content = new StringBuffer();

					public ContentHandler getContentHandler(
							AnnotationContext context,
							String parentElementName,
							ErrorHandler errorHandler,
							EntityResolver entityResolver) {
						return new ContentHandler() {
							public void characters(char[] ch, int start,
									int length) throws SAXException {
								content.append(ch, start, length);
							}

							public void endDocument() throws SAXException {
							}

							public void endElement(String uri,
									String localName, String name)
									throws SAXException {
							}

							public void endPrefixMapping(String prefix)
									throws SAXException {
							}

							public void ignorableWhitespace(char[] ch,
									int start, int length) throws SAXException {
							}

							public void processingInstruction(String target,
									String data) throws SAXException {
							}

							public void setDocumentLocator(Locator locator) {
							}

							public void skippedEntity(String name)
									throws SAXException {
							}

							public void startDocument() throws SAXException {
							}

							public void startElement(String uri,
									String localName, String name,
									Attributes atts) throws SAXException {
							}

							public void startPrefixMapping(String prefix,
									String uri) throws SAXException {
							}
						};
					}

					@Override
					public Object getResult(Object existing) {
						return content.toString();
					}
				};
			}
		});

		parser.parse(new File("/test/factura/cfdv2.xsd"));

		XSSchemaSet sset = parser.getResult();

		for (Iterator iterator = sset.iterateElementDecls(); iterator.hasNext();) {
			// Object type = iterator.next();
			XSElementDecl xsElement = (XSElementDecl) iterator.next();
			printXSElement(xsElement, "", false);
		}

	}

	private static void printXSElement(XSElementDecl xsElement,
			String parentElement, boolean isOptional) {
		final XSType type = xsElement.getType();
		XSContentType xsContentType = type.asComplexType().getContentType();
		if (type.isComplexType()) {
			printSingleXSElement(xsElement, parentElement, isOptional);
			XSParticle particle = xsContentType.asParticle();
			if (particle != null) {
				XSTerm term = particle.getTerm();
				if (term.isModelGroup()) {
					XSModelGroup xsModelGroup = term.asModelGroup();
					XSParticle[] particles = xsModelGroup.getChildren();
					for (XSParticle p : particles) {
						XSTerm pterm = p.getTerm();
						if (pterm.isElementDecl()) {
							XSElementDecl childElementDecl = (XSElementDecl) pterm;
							printXSElement(childElementDecl,
									(parentElement.equals("") ? ""
											: (parentElement + "/"))
											+ xsElement.getName(), p.getMinOccurs().intValue() == 0);
						}
					}
				}
			} else {
				System.out.println("---");
			}
		}
	}

	private static void printSingleXSElement(XSElementDecl xsElement,
			String parentElement, boolean isOptional) {
		System.out.println("ELEMENT: "
				+ (parentElement.equals("") ? "" : (parentElement + "/"))
				+ xsElement.getName() + " | " + (isOptional ? "O" : "R"));
		final XSType type = xsElement.getType();
		for (Iterator attributeIterator = type.asComplexType()
				.iterateAttributeUses(); attributeIterator.hasNext();) {
			AttributeUseImpl attribute = (AttributeUseImpl) attributeIterator
					.next();
			System.out.println("ATTRIBUTE: " + attribute.getDecl().getName()
					+ " | " + attribute.getDecl().getType().getName() + " | "
					+ (attribute.isRequired() ? "R" : "O"));
		}
		System.out.println();
	}
	
//	private static boolean isOptional(XSElementDecl xsElement) {
//		String elementName = xsElement.getName();
//	    final Iterator<XSElementDecl> iterateComplexTypes = xsElement.getSourceDocument().getSchema().iterateElementDecls();
//			
//	    for (Iterator<XSElementDecl> iterator = iterateComplexTypes; iterator.hasNext();) {
//	    	XSElementDecl elementDecl = (XSElementDecl) iterator.next();
//	        final XSContentType content = elementDecl.getType().asComplexType().getContentType();
//	        final XSParticle particle = content.asParticle();
//	        if (null != particle) {
//	            final XSTerm term = particle.getTerm();
//	            if (term.isModelGroup()) {
//	                final XSParticle[] particles = term.asModelGroup().getChildren();
//	                for (final XSParticle p : particles) {
//	                    final XSTerm pterm = p.getTerm();
//	                    if (pterm.isElementDecl()) {
//	                        final XSElementDecl e = pterm.asElementDecl();
//							if (0 == e.getName().compareToIgnoreCase(elementName)) {
//	                            return p.getMinOccurs().intValue() == 0;
//	                        }
//	                    }
//	                }
//	             }
//	          }
//	    }
//	    return true;
//	}

}
