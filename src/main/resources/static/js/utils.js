const REQUEST_TYPE = {
    GET: 'GET',
    POST: 'POST',
    PATCH: 'PATCH',
    PUT: 'PUT',
    DELETE: 'DELETE'
}
const requestFn = (type, endPoint, param, callback) => {
    let init = {
        method: type,
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(param)
    }
    if (type == REQUEST_TYPE.GET) {
        init = null
    }
    fetch(endPoint, init)
        .then((response) => {
            if (!response.ok)
                throw new Error('400 or 500 Error')
            return response.json()
        })
        .then((data) => {
            callback(data)
        })
        .catch(error => console.log(error))
}
