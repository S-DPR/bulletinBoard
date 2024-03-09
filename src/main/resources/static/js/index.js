window.addEventListener('load', () => {
    const postListTBody = document.querySelector('#postListTBody')
    const dels = document.querySelector('.del-btn') || []

    const refreshTable = () => {
        requestFn(REQUEST_TYPE.GET, "/post/", null, (data) => {
            data.forEach(data => {
                const tr = document.createElement('tr')
                tr.dataset.id = data.id
                tr.appendChild(createTitleTd(data))
                tr.appendChild(createWriterTd(data))
                postListTBody.appendChild(tr)
            })
        })
    }

    const createTitleTd = (data) => {
        const td = document.createElement('td')
        const a = document.createElement('a')
        a.textContent = data.title
        a.href = `/${data.id}`
        td.appendChild(a)
        return td
    }

    const createWriterTd = (data) => {
        const td = document.createElement('td')
        const a = document.createElement('a')
        a.textContent = data.writer
//        a.href = `/${data.id}`
        td.appendChild(a)
        return td
    }
    refreshTable()
})
