import axios from '../custom-axios/axios'

const CategoriesService = {
    fetchCategories: () => {
        return axios.get("/categories");
    }
}

export default CategoriesService;