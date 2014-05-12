package org.mxworld.hra.model.eo;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;

import oracle.jbo.server.TransactionEvent;

import org.mxworld.hra.common.framework.HraEntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Apr 27 21:32:46 EDT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ImagesImpl extends HraEntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ImageId,
        Image,
        ImageUsages;
        static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int IMAGEID = AttributesEnum.ImageId.index();
    public static final int IMAGE = AttributesEnum.Image.index();
    public static final int IMAGEUSAGES = AttributesEnum.ImageUsages.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ImagesImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("org.mxworld.hra.model.eo.Images");
    }


    @Override
    public void postChanges(TransactionEvent e) {
        /* Only references if Image is NEW */
        RowSet newImageUsagesBeforePost = null;
        if (getPostState() == STATUS_NEW) {
            // Store the rowset of imageUsages related
            // to this new image before calling super
            newImageUsagesBeforePost = (RowSet) getImageUsages();
        }
        super.postChanges(e);
        if (newImageUsagesBeforePost != null) {
            adjustImageUsages(newImageUsagesBeforePost);
        }
    }

    private void adjustImageUsages(RowSet newImageUsagesBeforePost) {
        Integer newFkValue = getImageId().getSequenceNumber().intValue();
        while (newImageUsagesBeforePost.hasNext()) {
            ImageUsagesImpl imageUsage = (ImageUsagesImpl) newImageUsagesBeforePost.next();
            imageUsage.setImageId(newFkValue);
        }
    }

    /**
     * Gets the attribute value for ImageId, using the alias name ImageId.
     * @return the value of ImageId
     */
    public DBSequence getImageId() {
        return (DBSequence) getAttributeInternal(IMAGEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImageId.
     * @param value value to set the ImageId
     */
    public void setImageId(DBSequence value) {
        setAttributeInternal(IMAGEID, value);
    }

    /**
     * Gets the attribute value for Image, using the alias name Image.
     * @return the value of Image
     */
    public String getImage() {
        return (String) getAttributeInternal(IMAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Image.
     * @param value value to set the Image
     */
    public void setImage(String value) {
        setAttributeInternal(IMAGE, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getImageUsages() {
        return (RowIterator) getAttributeInternal(IMAGEUSAGES);
    }

    /**
     * @param imageId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence imageId) {
        return new Key(new Object[] { imageId });
    }


}

