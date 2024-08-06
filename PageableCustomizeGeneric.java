public class PageableCustomize<T> {

    public  PageResponse<T> pageResponseCustomize(List<T> list, Pageable pageable,PageResponse<T> responsePage){
        int firstIndex = pageable.getPageNumber() * pageable.getPageSize() - pageable.getPageSize();
        int lastIndex = pageable.getPageNumber() * pageable.getPageSize();
        int totalPage = list.size() / pageable.getPageSize() + 1;
        if (pageable.getPageNumber() > totalPage ) {
            responsePage.setContent(null);
            responsePage.setTotalPages(totalPage);
            responsePage.setNumberOfElements(0);
            responsePage.setFirst(false);
            responsePage.setLast(true);
            responsePage.setEmpty(true);
            return responsePage;
        }
        if (lastIndex > list.size()) {
            List<T> subList = list.subList(firstIndex, list.size());
            responsePage.setContent(subList);
            responsePage.setTotalPages(list.size() / pageable.getPageSize()+1);
            responsePage.setNumberOfElements(subList.size());
            responsePage.setFirst(false);
            responsePage.setLast(true);
            responsePage.setEmpty(false);
            return responsePage;
        }
        if (lastIndex == list.size()) {
            List<T> subList = list.subList(firstIndex, list.size());
            responsePage.setContent(subList);
            responsePage.setTotalPages(list.size() / pageable.getPageSize());
            responsePage.setNumberOfElements(subList.size());
            responsePage.setFirst(false);
            responsePage.setLast(true);
            responsePage.setEmpty(false);
            return responsePage;
        }
        if(lastIndex < list.size()){
        List<T> list1 = list.subList(firstIndex, lastIndex);
        responsePage.setContent(list1);
        responsePage.setTotalPages(list.size() / pageable.getPageSize()+1);
        responsePage.setNumberOfElements(list1.size());
        if (firstIndex == 0) {
            responsePage.setFirst(true);
        }
        responsePage.setFirst(false);
        if (lastIndex == list.size()) {
            responsePage.setLast(true);
        }
        responsePage.setLast(false);
        responsePage.setEmpty(false);
        return responsePage;
        }
        List<T> list1 = list.subList(firstIndex, lastIndex);
        responsePage.setContent(list1);
        responsePage.setTotalPages(list.size() / pageable.getPageSize());
        responsePage.setNumberOfElements(list1.size());
        if (firstIndex == 0) {
            responsePage.setFirst(true);
        }
        responsePage.setFirst(false);
        if (lastIndex == list.size()) {
            responsePage.setLast(true);
        }
        responsePage.setLast(false);
        responsePage.setEmpty(false);
        return responsePage;
    }
}
